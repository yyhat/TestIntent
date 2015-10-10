package com.hat.tools;

import android.util.Log;

import com.hat.testjson.Person;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anting.hu on 2015/10/7.
 * startDocument
 *   startElement(...)
 *   characters
 *   endElement(...)
 * endElement
 */
public class SaxPersonHandler extends DefaultHandler {
    public List<Person> getPersons() {
        return persons;
    }

    private List<Person> persons;
    private Person person;
    private String currentTag;
    private String currentValue;

    public SaxPersonHandler() {
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        persons = new ArrayList<Person>();
        Log.i("test", "startDocument");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if("person".equals(qName))
        {
            person = new Person();
            person.setId(Integer.parseInt(attributes.getValue("id")));
        }
        currentTag = qName;
        Log.i("test", "startElement qName: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("person".equals(qName))
        {
            persons.add(person);
            person = null;
        }
        Log.i("test", "endElement qName: " + qName);

    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        Log.i("test", "endElement");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue = new String(ch, start, length);
        if(currentValue != null && !"".equals(currentValue) && !"\n".equals(currentValue))
        {
            if("name".equals(currentTag))
            {
                person.setName(currentValue);
            }
            else if("age".equals(currentTag))
            {
                person.setAge(Integer.parseInt(currentValue));
            }
        }
        currentValue = null;
        currentTag = null;
        Log.i("test", "characters");
    }
}
