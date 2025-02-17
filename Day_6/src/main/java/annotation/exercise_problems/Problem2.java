package annotation.exercise_problems;

class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("This is the old feature");
    }

    void newFeature() {
        System.out.println("This is the new feature");
    }
}

public class Problem2 {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // Warning: oldFeature() is deprecated
        api.newFeature(); // Output: This is the new feature
    }
}