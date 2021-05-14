package com.chenyu.part1.interfacedemo;

/**
 * @Select() 这种方式去读取sql 并执行
 *
 * @author chenyu
 * @date 2021-05-13
 */
public class InterfaceDemo {
  public static void main(String[] args) {
    User user = new User(1, "");
    user.getId();
  }
}

interface SelectDemo {
  //  @Select("select * from user where id = #{id} and name = #{name}")
  User select(int id, String name);
}
