package com.hat.tools;

import android.content.Context;

import com.hat.testjson.Person;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by anting.hu on 2015/10/7.
 * 使用SAX解析JSON， 事件驱动，是底层调用callback
 * SAXParserFactory-> SAXParser-> SaxPersonHandler(自定义)
 */
public class SaxParserUtils {

    public static List<Person> parserXmlBySax(Context context, int rawId) {
        List<Person> result = null;
        try {
            InputStream in = context.getResources().openRawResource(rawId);
            result = parserXmlBySax(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static List<Person> parserXmlBySax(InputStream in)
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        List<Person> persons = new ArrayList<Person>();

        try {
            SAXParser parser = factory.newSAXParser();
            SaxPersonHandler handler = new SaxPersonHandler();
            parser.parse(in, handler);
            persons = handler.getPersons();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }
}
