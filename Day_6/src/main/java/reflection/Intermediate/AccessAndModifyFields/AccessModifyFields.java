package reflection.Intermediate.AccessAndModifyFields;

import java.lang.reflect.*;

class Configuration {
    private static String API_KEY = "original-api-key";

    public static void printApiKey() {
        System.out.println("API Key: " + API_KEY);
    }
}

public class AccessModifyFields {
    public static void main(String[] args) throws Exception {
        // Get the Configuration class
        Class<?> clazz = Configuration.class;

        // Access the private static field 'API_KEY' using reflection
        Field apiKeyField = clazz.getDeclaredField("API_KEY");
        apiKeyField.setAccessible(true); // Set accessible to true to access private field

        // Modify the value of 'API_KEY'
        apiKeyField.set(null, "new-api-key");

        // Call the printApiKey method to see the updated value
        Configuration.printApiKey(); // This should print: "API Key: new-api-key"
    }
}














