public class MultiplyTwoNumbers {
    
    // Method to multiply two numbers
    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }
    
    // Main method
    public static void main(String[] args) {
        int number1 = 5;
        int number2 = 8;
        
        int product = multiply(number1, number2);
        
        System.out.println("First number: " + number1);
        System.out.println("Second number: " + number2);
        System.out.println("Product: " + product);
    }
}
