package com.chenyu.part1.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

/**
 * dom4j读取配置文件
 *
 * @author chenyu
 * @date 2021-05-19
 */
public class XmlReader {

  public static void main(String[] args) throws DocumentException {
    SAXReader reader = new SAXReader();
    Document document =
        reader.read(XmlReader.class.getClassLoader().getResource("mybatis.xml").getPath());

    /** 第一种方式 采取迭代器循环的方式 适合全局的解析 */
    Element root = document.getRootElement();
    // iterate through child elements of root
    for (Iterator<Element> it = root.elementIterator(); it.hasNext(); ) {
      // root标签
      Element element = it.next();
    }

    for (Iterator<Element> it = root.elementIterator("environments"); it.hasNext(); ) {
      Element element = it.next();
      for (Iterator<Element> it2 = element.elementIterator("environment"); it2.hasNext(); ) {
        Element element2 = it2.next();
        System.out.println();
      }
    }

    /** 第二种可以通过xpath快速定位标签 需要添加jar包 */
    List<Node> list = document.selectNodes("//configuration/environments/environment/dataSource");
    for (int i = 0; i < list.size(); i++) {
      //
    }

    /** 第三种 如果xml过大 官网推荐快速排序（递归）去处理 */
  }
}
