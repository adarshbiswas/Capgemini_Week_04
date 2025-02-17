package reflection.Advanced.DependencyInjectionReflection;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class Service {
    public void execute() {
        System.out.println("Service is executed!");
    }
}

class Consumer {
    @Inject
    private Service service;

    public void run() {
        service.execute();
    }
}

public class DependencyInjection {
    public static void injectDependencies(Object obj) throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(obj, new Service());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Consumer consumer = new Consumer();
        injectDependencies(consumer);
        consumer.run();
    }
}
