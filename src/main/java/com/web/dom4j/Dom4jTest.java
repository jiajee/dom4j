package com.web.dom4j;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jTest {
	
	//读取xml
	private static Document readXML() {
		SAXReader reader = new SAXReader();
		try {
			return reader.read(Dom4jTest.class.getClassLoader().getResourceAsStream("student.xml"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//读取所有学生的元素打印出来
	private static void readStudentEle() {
		Document document = readXML();
		Element root = document.getRootElement();
		for(Iterator<Element> iter=root.elementIterator("student");iter.hasNext();) {
			Element stuEle = iter.next();
			String number = stuEle.attributeValue("number");
			String name = stuEle.elementText("name");
			String age = stuEle.elementText("age");
			String sex = stuEle.elementText("sex");
			System.out.println(number + " " + name + " " + age + " " + sex);
		}
	}

	
	private static void addStudentEle() {
		//1.获得根元素
		Document document = readXML();
		Element root = document.getRootElement();
		//2.添加一个sutdent Element
		Element studentElement = root.addElement("student").addAttribute("number", "student003");
		//3.添加一个name sex sex element
		studentElement.addElement("name").addText("jack");
		studentElement.addElement("age").addText("32");
		studentElement.addElement("sex").addText("male");
		
		//4.将document对象写到文件中
		OutputFormat output = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = null;
		try {
			xmlWriter = new XMLWriter(new PrintWriter("src/main/resources/studentadd.xml","UTF-8"), output);
			xmlWriter.write(document);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			 if(null != xmlWriter) {
				 try {
					xmlWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
		}
		
	}
	
	private static void deleteStudentEle() {
		Document document = readXML();
		String xpath = "//student[@number='student001']";
		Element student = (Element) document.selectSingleNode(xpath);
		//删除操作
		System.out.println(student.getParent().remove(student));;
		//回写
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream("src/main/resources/studentremove.xml"),OutputFormat.createPrettyPrint());
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//修改学生
	private static void modifyStudent() {
		Document document = readXML();
		
		//1.定义xpath表达式
		String xpathStr = "//student[@number='student001']";
		//2.使用xpath查找
		Element student = (Element) document.selectSingleNode(xpathStr);
		//3.修改Element student元素
		student.attribute("number").setData("student100");
		student.element("name").setText("rose");
		student.element("age").setText("18");
		student.element("sex").setText("female");
		//回写
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream("src/main/resources/studentmodify.xml"),OutputFormat.createPrettyPrint());
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		modifyStudent();
	}
}
