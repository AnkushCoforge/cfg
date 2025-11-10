public class DivideTwoNumbers {
    
    // Method to divide two numbers
    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }
    
    // Main method
    public static void main(String[] args) {
        double number1 = 20.0;
        double number2 = 4.0;
        
        try {
            double quotient = divide(number1, number2);
            
            System.out.println("First number: " + number1);
            System.out.println("Second number: " + number2);
            System.out.println("Quotient: " + quotient);
            
            // Example with division by zero
            System.out.println("\nAttempting to divide by zero:");
            divide(10, 0);
            
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
