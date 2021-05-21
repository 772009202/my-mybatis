package com.chenyu.part1.jdbc;

/**
 * @author chenyu
 * @date 2021-0 吧2
 *     <p>；lkjhgfxzkl5-13
 */
public class JDBCTestDemo {

  public static void main(String[] args) {
    try {
      // 驱动的类8版本上变了
      Class.forName("com.mysql.cj.jdbc.Driver");
      //      String resource = "org/mybatis/example/mybatis-config.xml";
      //      InputStream inputStream = Resources.getResourceAsStream(resource);
      //      SqlSessionFactory sqlSessionFactory = new
      // SqlSessionFactoryBuilder().build(inputStream);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
