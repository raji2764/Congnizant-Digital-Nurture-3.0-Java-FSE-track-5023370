/*Concept of Recursion:
Recursion is a technique where a method calls itself to solve smaller instances of the same problem.
Base Case: The termination condition that stops the recursion.
Recursive Case: The part of the method that reduces the problem and calls itself. */

public class FinancialForeCasting {
    public static void main(String[] args) {
        double initialValue = 1000.0; // Initial value
        double growthRate = 0.05; // 5% growth rate
        int years = 10; // Number of years to forecast
        // Calculate future value using recursive approach
        double futureValue = calculateFutureValue(initialValue, growthRate, years);
        System.out.printf("The future value after %d years is: %.2f%n", years, futureValue);
    }

    /**
     * Recursively calculates the future value of an investment.
     * 
     * initialValue The initial investment value.
     * growthRate The annual growth rate (e.g., 0.05 for 5%).
     * years The number of years to forecast.
     * The future value of the investment.
     */

    public static double calculateFutureValue(double initialValue, double growthRate, int years) {
        if (years <= 0) {
            return initialValue; // Base case: No growth if years is 0 or negative
        } else {
            return calculateFutureValue(initialValue * (1 + growthRate), growthRate, years - 1);
        }
    }

    static double calculateFutureValueIterative(double initialValue, double growthRate, int years) {
        double futureValue = initialValue;
        for (int i = 0; i < years; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

}
// Analysis
/*
 * Time Complexity:
 * The time complexity of the recursive calculateFutureValue method is O(n),
 * where n is the number of years. This is because the method makes a recursive
 * call for each year.
 */
/*
 * Optimization:
 * Memoization: Store intermediate results to avoid redundant calculations. This
 * is particularly useful for more complex recursive problems.
 */