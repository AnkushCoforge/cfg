public class AddTwoNumbers {
    
    // Method to add two numbers
    public static int add(int num1, int num2) {
        return num1 + num2;
    }
    
    // Main method
    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 20;
        
        int sum = add(number1, number2);
        
        System.out.println("First number: " + number1);
        System.out.println("Second number: " + number2);
        System.out.println("Sum: " + sum);
    }
}
