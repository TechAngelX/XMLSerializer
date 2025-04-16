package com.techangelx;

public class Address {
    private String f, s, p;

    public Address(String f, String s, String p) {
        this.f = f;
        this.s = s;
        this.p = p;
    }

    public String getFirstLine() { return f; }
    public String getSecondLine() { return s; }
    public String getPostcode() { return p; }
}
