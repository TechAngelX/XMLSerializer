package com.techangelx;

import java.lang.reflect.Method;

/**
 * A utility class for converting Java objects into XML string representations using reflection.
 * <p>
 * This class inspects the runtime methods of an object, specifically its getter methods,
 * and constructs an XML string based on the values returned by those getters.
 * It is designed to work generically with any standard Java object (POJO).
 * <p>
 * Example usage:
 * <pre>{@code
 * Person person = new Person(null, "Alice", 30);
 * String xml = XmlSerializer.toXml(person);
 * }</pre>
 *
 * <p><strong>Note:</strong*
 */
public class XmlSerializer {

    //🔹 This method is the entry point. It takes any object and passes it to a private helper 
    // with an extra flag: true, which means "this is the outermost object.    
    public static String asXml (Object obj) {
        return asXml(obj, true);
    }

    // Why two versions of asXml?
    // The public version is what users call directly. The private version does the real work
    // — and it uses the second parameter outermost to know whether to add <ClassName> 
    // and </ClassName> tags.


    // This private method does the actual work. It starts by checking if the passed
    // object is null. If it is, it returns an empty string (nothing to serialize).       
    private static String asXml(Object obj, boolean outermost) {
        if (obj == null) return "";

        Class <?> clazz = obj.getClass();
        StringBuilder xml = new StringBuilder();

        if (outermost) {
            xml.append("<").append(clazz.getSimpleName()).append(">\n");
        }

        // Person is the outermost tag → we wrap the whole thing
        // Address is a nested object → we don’t wrap it again unless needed.

        for (Method method : clazz.getMethods()) {
            // Skip Object methods and invalid getter names
            if (method.getDeclaringClass() == Object.class) continue;
            if (!method.getName().startsWith("get")) continue;
            if (method.getParameterCount() != 0) continue;

            // Extract the property name after 'get'
            String propertyName = method.getName().substring(3);
            if (propertyName.isEmpty() || !Character.isUpperCase(propertyName.charAt(0))) continue;

            // Lowercase the first character to match XML naming style
            propertyName = Character.toLowerCase(propertyName.charAt(0)) + propertyName.substring(1);

            try {
                Object value = method.invoke(obj);
                //method.invoke(obj) calls the getter method on the obj and retrieves its value. 
                // The result is stored in the value variable.
                

                if (value == null) {
                    xml.append("<").append(propertyName).append(" xsi:nil=\"true\"/>\n");
                } else if (value instanceof String || value instanceof Integer) {
                    xml.append("<").append(propertyName).append(">")
                            .append(value)
                            .append("</").append(propertyName).append(">\n");
                } else {
                    // Nested object If the value is another object (not a primitive or String), 
                    // this section handles nested objects by calling asXml(value, false). The false means 
                    // that the nested object will not have its own root element. This allows the method to 
                    // recursively convert nested objects into XML.
                    
                    xml.append("<").append(propertyName).append(">\n");
                    xml.append(asXml(value, false));
                    xml.append("</").append(propertyName).append(">\n");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (outermost) {
            xml.append("</").append(clazz.getSimpleName()).append(">\n");
        }

        return xml.toString();
    }
}
