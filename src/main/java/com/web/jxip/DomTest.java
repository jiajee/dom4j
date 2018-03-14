package com.web.jxip;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * dom4j 解析xml文件
 * 
 * @author Administrator
 *
 */
public class DomTest {
	public static void main(String[] args) {
		//1.获得jaxp工厂
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		//2.通过工厂获得解析器实现类
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			//3.使用解析器解析xml文件生成dom对象
			Document doc = documentBuilder.parse(new File("student.xml"));
			NodeList studentList = doc.getElementsByTagName("student");
			for(int i = 0; i < studentList.getLength(); i++) {
				Element stuEle = (Element) studentList.item(i);
				//获得学生属性
				String stuNum = stuEle.getAttribute("number");
				//获得学校节点下的所有节点
				NodeList childNodes = stuEle.getChildNodes();
				//遍历集合提取出想要的name age sex 元素对象
				for(int j = 0; j < childNodes.getLength(); j++) {
					Node node = childNodes.item(j);
//					if(node instanceof Element) {
//						
//					}
					if(node.getNodeType() == Node.ELEMENT_NODE) {
						Element child = (Element) node;
						if(node.getNodeName() == "name") {
							String name = child.getTextContent();
						}else if(node.getNodeName() == "age") {
							String age = child.getTextContent();
						}else if(node.getNodeName() == "sex") {
							String sex = child.getTextContent();
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
