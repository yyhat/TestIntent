package com.hat.testintent;

import android.app.Application;

/**
 * Created by anting.hu on 2015/9/30.
 */
public class MyApp extends Application
{
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String Name;

}
