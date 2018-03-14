package com.web.jxip.sax;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXTest {
	public static void main(String[] args) {
		//1.获得解析器工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			//2.获得解析器
			SAXParser newSAXParser = factory.newSAXParser();
			//3.解析文档
//			newSAXParser.parse(is, dh);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
}
