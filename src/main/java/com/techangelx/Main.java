package com.techangelx;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Malet St", "London", "WC1E 7HX");
        Person person = new Person(null, "Josh", 2003, address);

        String xml = XmlSerializer.asXml(person);
        System.out.println(xml);
    }
}
