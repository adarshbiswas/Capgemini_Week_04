package reflection.Advanced.JSONRepresentation;

import java.lang.reflect.*;

class Car {
    private String model;
    private int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

public class JsonRepresent {
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            json.append("\"").append(field.getName()).append("\": \"")
                    .append(field.get(obj)).append("\"");
            if (i < fields.length - 1) {
                json.append(", ");
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        Car car = new Car("Tesla", 2022);
        String json = toJson(car);
        System.out.println(json);  // Output: {"model": "Tesla", "year": "2022"}
    }
}

