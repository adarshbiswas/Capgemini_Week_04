package reflection.Advanced.CustomLoggingProxy;

import java.lang.reflect.*;

interface Greeting {
    void sayHello(String name);
}

class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }
}

public class CustomLogging {
    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();

        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Method called: " + method.getName());
                        return method.invoke(greeting, args);
                    }
                });

        proxy.sayHello("John");
    }
}











