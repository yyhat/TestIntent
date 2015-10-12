package com.hat.tools;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hat.testjson.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anting.hu on 2015/10/8.
 */
public class GsonParserUtils {

    public static <T> T getPerson(String jsonData, Class<T> cls)
    {
        T person = null;
        Gson gson = new Gson();
        person = gson.fromJson(jsonData, cls);
        return person;
    }

    //使用泛型处理的时候，打印会报错
//    public static  List<Person> getPersons(String jsonData, Class<Person> cls)
//    {
//        List<Person> persons = new ArrayList<Person>();
//        Gson gson = new Gson();
//        persons = gson.fromJson(jsonData, new TypeToken<List<Person>>(){}.getType());
//        return persons;
//    }

    public static <T> List<T> getPersons(String jsonData, Class<T[]> cls)
    {
        T[] persons = new Gson().fromJson(jsonData, cls); //不可以写成 new TypeToken<T[]>(){}.getType());
        return Arrays.asList(persons);
    }
}
