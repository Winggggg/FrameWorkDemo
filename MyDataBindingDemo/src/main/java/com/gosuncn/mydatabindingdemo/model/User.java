package com.gosuncn.mydatabindingdemo.model;

/**
 * Created by wing on 2018/5/4 0004.
 * 用户信息类
 */

public class User {
    private final String mFirstName;
    private final String mLastName;
    private int mAge;

    public User(String firstName, String lastName, int age) {
        this(firstName, lastName);
        mAge = age;
    }

    public User(String firstName, String lastName) {
        mFirstName = firstName;
        mLastName = lastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getFullName() {
        return mFirstName + " " + mLastName;
    }

    public int getAge() {
        return mAge;
    }

    public boolean isAdult() {
        return mAge >= 18;
    }
}
