// Problem 4: Personalized Meal Plan Generator
package personalized_meal_plan_generator;

// Interface for meal plans
interface MealPlan {}
class VegetarianMeal implements MealPlan {}
class VeganMeal implements MealPlan {}

// Generic class for meal plans
class Meal<T extends MealPlan> {
    private T meal;
    public Meal(T meal) { this.meal = meal; }
    public T getMeal() { return meal; }

public static class MealPlanGenerator {
        public static void main(String[] args) {
            Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
            System.out.println("Vegan Meal Plan Created: " + veganMeal.getMeal().getClass().getSimpleName());
        }
    }
}
