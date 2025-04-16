package com.techangelx;

public class Main {
    public static void main(String[] args) {
        Salary salary = new Salary(30500.33);
        Address address = new Address("Malet St", "London", "WC1E 7HX");
        Person person = new Person(null, "Josh", 2003, address,salary);
        Dog dog = new Dog("Puppa", address,3 );


        String xml = XmlSerializer.asXml(dog);
        System.out.println(xml);
    }
}
