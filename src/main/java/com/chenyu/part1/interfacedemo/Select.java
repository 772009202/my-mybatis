package com.chenyu.part1.interfacedemo;

import java.lang.annotation.*;

/**
 * Created by chenyu on 2021/5/13
 *
 * @author chenyu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Select {
  String value();
}
