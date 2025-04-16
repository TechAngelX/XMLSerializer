package com.techangelx;

public class Person {
    private String t, n;
    private int y;
    private Address a;
    private Salary s;

    public Person(String title, String name, int yearOfBirth, Address address, Salary s) {
        this.t = title;
        this.n = name;
        this.y = yearOfBirth;
        this.a = address;
        this.s = s;
    }
    

    public String getTitle() { return t; }
    public String getName() { return n; }
    public int getYearOfBirth() { return y; }
    public Address getAddress() { return a; }
    public Salary getSalary() { return s; }

    // NOT a valid getter
    public String getterForName() { return n; }
}

