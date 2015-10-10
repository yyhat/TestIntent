package com.hat.tools;

import android.content.Context;
import android.util.Log;

import com.hat.testjson.Person;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by anting.hu on 2015/10/7.
 * 使用DOM解析XML, 基于Tree解析，需要将整个json文件读取到内存，如果文件比较大，则会占用比较多内存
 * DocumentBuilderFactory-> DocumentBuilder->Element->NodeList
 */
public class DomParserUtils {

    public static List<Person> parserXmlByDom(Context context, int rawId) {
        List<Person> result = null;
        try {
            InputStream in = context.getResources().openRawResource(rawId);
            result = parserXmlByDom(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static List<Person> parserXmlByDom(InputStream in) {
        List<Person> persons = new ArrayList<Person>();
        //得到工厂类
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            //获得DocumentBuilder解析类
            DocumentBuilder builder = factory.newDocumentBuilder();
            //接收一个xml的字符串来解析xml,Document代表整个xml文档
            Document doc = builder.parse(in);
            //得到根节点
            Element root = doc.getDocumentElement();
            //得到所有节点
            NodeList nodeList = root.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Person person = new Person();
                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element personElement = (Element) nodeList.item(i);
                    person.setId(Integer.parseInt(personElement.getAttribute("id")));

                    //    得到person元素下的子元素
                    NodeList childNodesList = personElement.getChildNodes();
                    for (int j = 0; j < childNodesList.getLength(); j++)
                    {
                        if (childNodesList.item(j).getNodeType() == Node.ELEMENT_NODE)
                        {
                            if ("name".equals(childNodesList.item(j).getNodeName()))
                                person.setName(childNodesList.item(j).getFirstChild().getNodeValue());
                            else if ("age".equals(childNodesList.item(j).getNodeName()))
                                person.setAge(Integer.parseInt(childNodesList.item(j).getFirstChild().getNodeValue()));
                        }
                    }
                    persons.add(person);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }
}
