package com.hat.tools;

import android.content.Context;

import com.hat.testjson.Person;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anting.hu on 2015/10/7.
 * 使用Android Json解析Json
 */
public class JsonParserUtils
{
    public static List<Person> parserJsonByJSON(String jsonContent)
    {
        List<Person> persons = new ArrayList<Person>();

        try {
            JSONObject root = new JSONObject(jsonContent);
            JSONArray jsonArray = root.getJSONArray("person");
            for(int i=0; i< jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Person person = new Person();
                person.setId(jsonObject.getInt("id"));
                person.setAge(jsonObject.getInt("age"));
                person.setName(jsonObject.getString("name"));
                persons.add(person);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return persons;
    }
}
