package com.chenyu.part1.interfacedemo;

import com.google.common.collect.Maps;
import com.mysql.cj.util.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Map;

/**
 * 模拟<br>
 * @Select() 这种方式去读取sql 并执行
 *
 * @author chenyu
 * @date 2021-05-13
 */
public class InterfaceDemo {
  public static void main(String[] args) {
    // step1:通过jdk动态代理获取新对象
    SelectDemo select =
        (SelectDemo)
            Proxy.newProxyInstance(
                InterfaceDemo.class.getClassLoader(),
                new Class[] {SelectDemo.class},
                (Object proxy, Method method, Object[] methodArgs) -> {
                  Select selectAnnotation = method.getAnnotation(Select.class);
                  if (selectAnnotation != null) {
                    String sqlStr = selectAnnotation.value();
                    if (!StringUtils.isNullOrEmpty(sqlStr)) {
                      Map<String, Object> paramMap = getParamMapByArgs(method, methodArgs);
                      String executeSql = parseSqlByParam(sqlStr, paramMap);
                      System.out.println(executeSql);
                    }
                  }

                  return null;
                });
    select.select(1, "chenyu");
  }

  /**
   * 将method参数名作为key，arg作为value，去sql中替换
   *
   * @param method
   * @param methodArgs
   * @return
   */
  public static Map<String, Object> getParamMapByArgs(Method method, Object[] methodArgs) {
    Parameter[] parameters = method.getParameters();
    Map<String, Object> paramMap = Maps.newHashMap();
    int[] index = {0};
    Arrays.asList(parameters)
        .forEach(
            parameter -> {
              String name = parameter.getName();
              paramMap.put(name, methodArgs[index[0]]);
              index[0]++;
            });
    return paramMap;
  }

  public static String parseSqlByParam(String sql, Map<String, Object> paramMap) {
    // 这里用替换的方式去做 不好 准备参考mybatis 通过字符比对去做 -- 待优化
    for (String e : paramMap.keySet()) {
      String replaceStr = "#{" + e + "}";
      sql = sql.replace(replaceStr, paramMap.get(e) == null ? "" : paramMap.get(e).toString());
    }

    return sql;
  }
}

interface SelectDemo {
  @Select("select * from user where id = #{id} and name = #{name}")
  User select(int id, String name);
}
