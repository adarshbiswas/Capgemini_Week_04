package reflection.Advanced.MethodExecutionTiming;

import java.lang.reflect.*;

class MyClass {
    public void performTask() {
        try {
            Thread.sleep(1000);  // Simulate a task
            System.out.println("Task performed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class MethodExecution {
    public static void measureExecutionTime(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);

        long startTime = System.currentTimeMillis();
        method.invoke(obj);
        long endTime = System.currentTimeMillis();

        System.out.println("Execution time: " + (endTime - startTime) + " ms");
    }

    public static void main(String[] args) throws Exception {
        MyClass myClass = new MyClass();
        measureExecutionTime(myClass, "performTask");
    }
}











