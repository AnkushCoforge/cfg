public class DivideTwoNumbers {
    
    // Method to divide two numbers with comprehensive exception handling
    public static double divide(double num1, double num2) {
        // Check for division by zero
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        
        // Check for NaN (Not a Number)
        if (Double.isNaN(num1) || Double.isNaN(num2)) {
            throw new IllegalArgumentException("Input cannot be NaN (Not a Number)");
        }
        
        // Check for infinity
        if (Double.isInfinite(num1) || Double.isInfinite(num2)) {
            throw new IllegalArgumentException("Input cannot be infinite");
        }
        
        double result = num1 / num2;
        
        // Check if result is valid
        if (Double.isNaN(result)) {
            throw new ArithmeticException("Result is not a valid number");
        }
        
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Result is infinite");
        }
        
        return result;
    }
    
    // Main method
    public static void main(String[] args) {
        double number1 = 20.0;
        double number2 = 4.0;
        
        try {
            // Test normal division
            double quotient = divide(number1, number2);
            System.out.println("First number: " + number1);
            System.out.println("Second number: " + number2);
            System.out.println("Quotient: " + quotient);
            
            // Test division by zero
            System.out.println("\nTest 1: Attempting to divide by zero:");
            divide(10, 0);
            
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
        
        // Test NaN input
        try {
            System.out.println("\nTest 2: Attempting to divide with NaN:");
            divide(Double.NaN, 5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
        
        // Test infinity input
        try {
            System.out.println("\nTest 3: Attempting to divide with infinity:");
            divide(Double.POSITIVE_INFINITY, 5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
        
        // Test successful edge case
        try {
            System.out.println("\nTest 4: Dividing very small numbers:");
            double result = divide(0.0001, 0.0002);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
