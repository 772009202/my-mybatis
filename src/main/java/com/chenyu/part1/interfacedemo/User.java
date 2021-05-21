package com.chenyu.part1.interfacedemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenyu
 * @date 2021-05-13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private int id;
  private String name;
}
