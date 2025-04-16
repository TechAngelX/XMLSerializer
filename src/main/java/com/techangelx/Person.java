package com.techangelx;

public class Person {
    private String t, n;
    private int y;
    private Address a;

    public Person(String title, String name, int yearOfBirth, Address address) {
        this.t = title;
        this.n = name;
        this.y = yearOfBirth;
        this.a = address;
    }

    public String getTitle() { return t; }
    public String getName() { return n; }
    public int getYearOfBirth() { return y; }
    public Address getAddress() { return a; }

    // NOT a valid getter
    public String getterForName() { return n; }
}

