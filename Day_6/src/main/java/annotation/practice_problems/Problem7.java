package annotation.practice_problems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {
}

class ExpensiveTask {
    private Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    int compute(int input) {
        if (cache.containsKey(input)) {
            return cache.get(input);
        }
        int result = input * input; // Simulate expensive computation
        cache.put(input, result);
        return result;
    }
}

public class Problem7 {
    public static void main(String[] args) {
        ExpensiveTask task = new ExpensiveTask();
        System.out.println(task.compute(5)); // Output: 25 (computed)
        System.out.println(task.compute(5)); // Output: 25 (cached)
    }
}