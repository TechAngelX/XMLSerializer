package com.techangelx;

public class Dog {
    private String s;
    private int age;
    private Address a;

    
    public Dog(String s, Address address, int age) {
        this.s = s;
        this.age = age;
        this.a = address;
    }

    public String getS() {
        return s;
    }

    public int getAge() {
        return age;
    }

    public Address getA() {
        return a;
    }
}
