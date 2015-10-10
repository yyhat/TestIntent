package com.hat.tools;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hat.testjson.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anting.hu on 2015/10/8.
 */
public class GsonParserUtils {

    public static Person getPerson(String jsonData, Class<Person> cls)
    {
        Person person = null;
        Gson gson = new Gson();
        person = gson.fromJson(jsonData, cls);
        return person;
    }

    public static List<Person> getPersons(String jsonData, Class<Person> cls)
    {
        List<Person> persons = new ArrayList<Person>();
        Gson gson = new Gson();
        persons = gson.fromJson(jsonData, new TypeToken<List<Person>>(){}.getType());
        return persons;
    }
}
