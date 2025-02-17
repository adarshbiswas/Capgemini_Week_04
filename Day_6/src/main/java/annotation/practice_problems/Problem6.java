package annotation.practice_problems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    User(String username) {
        this.username = username;
    }

    String toJson() {
        return "{\"" + this.getClass().getDeclaredFields()[0].getAnnotation(JsonField.class).name() + "\":\"" + username + "\"}";
    }
}

public class Problem6 {
    public static void main(String[] args) {
        User user = new User("john_doe");
        System.out.println(user.toJson()); // Output: {"user_name":"john_doe"}
    }
}