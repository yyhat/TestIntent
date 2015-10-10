package com.hat.tools;

import android.content.Context;
import android.util.Log;

import com.hat.testjson.Person;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anting.hu on 2015/10/7.
 * 使用PULL解析Json，事件驱动，但是事件需要自己驱动
 * XmlPullParserFactory-> XmlPullParser
 */
public class PullParserUtils {

    public static List<Person> parserXmlByPull(Context context, int rawId) {
        List<Person> result = null;
        try {
            InputStream in = context.getResources().openRawResource(rawId);
            result = parserXmlByPull(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Person> parserXmlByPull(InputStream inputStream) {
        List<Person> persons = null;
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(inputStream, "utf-8");

            Person person = null;

            //    得到当前的事件类型
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT)
            {
                switch (eventType)
                {
                    //Json开始
                    case XmlPullParser.START_DOCUMENT:
                        Log.i("test", "XmlPullParser.START_DOCUMENT");
                        persons = new ArrayList<Person>();
                        break;

                    //遍历节点开始
                    case XmlPullParser.START_TAG:
                        Log.i("test", "XmlPullParser.START_TAG tag:" + parser.getName());
                        if("person".equals(parser.getName()))
                        {
                            person = new Person();
                            person.setId(Integer.parseInt(parser.getAttributeValue(0)));
                        }
                        else if("name".equals(parser.getName()))
                        {
                            try {
                                person.setName(parser.nextText());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        else if("age".equals(parser.getName()))
                        {
                            try {
                                person.setAge(Integer.parseInt(parser.nextText()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        break;

                    //遍历节点结束
                    case XmlPullParser.END_TAG:
                        Log.i("test", "XmlPullParser.END_TAG tag:" + parser.getName());
                        if("person".equals(parser.getName())) {
                            persons.add(person);
                            person = null;
                        }
                        break;

                    //json结束
                    case XmlPullParser.END_DOCUMENT:
                        Log.i("test", "XmlPullParser.END_DOCUMENT");
                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return persons;
    }
}
