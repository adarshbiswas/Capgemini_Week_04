package annotation.practice_problems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    User(String username) {
        if (username.length() > this.getClass().getDeclaredFields()[0].getAnnotation(MaxLength.class).value()) {
            throw new IllegalArgumentException("Username exceeds maximum length");
        }
        this.username = username;
    }
}

public class Problem4 {
    public static void main(String[] args) {
        try {
            User user = new User("verylongusername"); // Throws IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}