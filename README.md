# XMLSerializer

A lightweight XML serializer in Java using the Reflection API. Converts POJOs into XML format by inspecting public getter methods. Designed for basic types (`int`, `String`) and null handling — no external libraries required.

©2025 Ricki Angel
---

## 🔧 Environment

- **Java Version:** 21
- **Encoding:** UTF-8
- **Build Tool:** Maven (optional — not required to run)
- **Libraries Used:** _None_ (Pure Java, no dependencies)

---

## ✅ Features

- Converts objects into well-formed XML.
- Uses public getters (`getXyz()`) to determine fields.
- Supports `int`, `String`, and `null` values.
- Handles nested objects recursively.
- Outputs `xsi:nil="true"` for null values.
- Ignores methods that don't follow the standard getter pattern.

---
## 📝 How to Use

1. **Add the XmlSerializer to your project**
    - Copy the `XmlSerializer.java` file into your project's appropriate package.

2. **Create objects with proper getter methods**
    - Ensure your classes have getter methods that follow the JavaBeans convention.
    - Valid getters start with "get" followed by a capitalized property name (e.g., `getName()`).

3. **Call the serializer**
    - Use the static `asXml()` method to convert your objects to XML.

   ```java
   // Create your object
   Person person = new Person(null, "Josh", 2003);
   
   // Serialize to XML
   String xml = XmlSerializer.asXml(person);
   
   // Use the XML string
   System.out.println(xml);
   
## 📄 Example Output

For the following class:

```java
public class Person {
    private String title;
    private String name;
    private int yearOfBirth;

    public Person(String title, String name, int yearOfBirth) {
        this.title = title;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getTitle() { return title; }
    public String getName() { return name; }
    public int getYearOfBirth() { return yearOfBirth; }
}
