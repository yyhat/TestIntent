package com.hat.testjson;

/**
 * Created by anting.hu on 2015/10/7.
 */
public class Person {


    /**
     * id : 1
     * name : 小罗
     * age : 21
     */

    private int id;
    private String name;
    private int age;

    @Override
    public String toString() {

        return "id: " + id + ", Name: " + name + ", Age: " + age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
