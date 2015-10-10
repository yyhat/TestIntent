package com.hat.testjson;

/**
 * Created by anting.hu on 2015/10/7.
 */
public class Person {
    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int Id;
    public String Name;
    public int Age;

    @Override
    public String toString() {

        return "id: " + Id + ", Name: " + Name + ", Age: " + Age;
    }
}
