package com.chenyu.part1.jdbc;

/**
 * @author chenyu
 * @date 2021-05-13
 */
public class JDBCTestDemo {

  public static void main(String[] args) {
    try {
      // 驱动的类8版本上变了
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
