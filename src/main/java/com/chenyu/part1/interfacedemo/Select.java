package com.chenyu.part1.interfacedemo;

import java.lang.annotation.*;

/**
 * 自定义注解 模拟mybatis注解 <br>
 * Created by chenyu on 2021/5/13
 *
 * @author chenyu
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Select {
  String value();
}
