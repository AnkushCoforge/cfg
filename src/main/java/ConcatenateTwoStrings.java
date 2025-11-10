public class ConcatenateTwoStrings {
    
    // Method to concatenate two strings using + operator with comprehensive exception handling
    public static String concatenate(String str1, String str2) {
        // Check for null values
        if (str1 == null && str2 == null) {
            throw new IllegalArgumentException("Both strings cannot be null");
        }
        if (str1 == null) {
            throw new IllegalArgumentException("First string cannot be null");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("Second string cannot be null");
        }
        
        try {
            return str1 + str2;
        } catch (OutOfMemoryError e) {
            throw new RuntimeException("Out of memory while concatenating strings", e);
        }
    }
    
    // Method to concatenate with space between strings
    public static String concatenateWithSpace(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Strings cannot be null for concatenation with space");
        }
        
        try {
            return str1 + " " + str2;
        } catch (OutOfMemoryError e) {
            throw new RuntimeException("Out of memory while concatenating strings with space", e);
        }
    }
    
    // Method to concatenate using StringBuilder (more efficient for multiple concatenations)
    public static String concatenateUsingStringBuilder(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Strings cannot be null for StringBuilder concatenation");
        }
        
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str1);
            sb.append(str2);
            return sb.toString();
        } catch (OutOfMemoryError e) {
            throw new RuntimeException("Out of memory while using StringBuilder", e);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred during StringBuilder concatenation: " + e.getMessage(), e);
        }
    }
    
    // Method to concatenate using String.concat()
    public static String concatenateUsingConcat(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Strings cannot be null for concat() method");
        }
        
        try {
            return str1.concat(str2);
        } catch (OutOfMemoryError e) {
            throw new RuntimeException("Out of memory while using concat() method", e);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred during concat(): " + e.getMessage(), e);
        }
    }
    
    // Safe concatenation method that handles nulls gracefully
    public static String safeConcatenate(String str1, String str2) {
        String safe1 = (str1 == null) ? "" : str1;
        String safe2 = (str2 == null) ? "" : str2;
        
        try {
            return safe1 + safe2;
        } catch (OutOfMemoryError e) {
            throw new RuntimeException("Out of memory during safe concatenation", e);
        }
    }
    
    // Main method
    public static void main(String[] args) {
        String string1 = "Hello";
        String string2 = "World";
        
        // Test 1: Normal concatenation
        try {
            System.out.println("=== Test 1: Normal Concatenation ===");
            String result1 = concatenate(string1, string2);
            System.out.println("Method 1 (+ operator): " + result1);
            
            String result2 = concatenateWithSpace(string1, string2);
            System.out.println("Method 2 (with space): " + result2);
            
            String result3 = concatenateUsingStringBuilder(string1, string2);
            System.out.println("Method 3 (StringBuilder): " + result3);
            
            String result4 = concatenateUsingConcat(string1, string2);
            System.out.println("Method 4 (concat()): " + result4);
            
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException: " + e.getMessage());
        }
        
        // Test 2: Concatenating with empty strings
        try {
            System.out.println("\n=== Test 2: Concatenating with Empty String ===");
            String result5 = concatenate("Java", "");
            System.out.println("Result: '" + result5 + "'");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Test 3: Testing with null (first string)
        try {
            System.out.println("\n=== Test 3: First String is Null ===");
            concatenate(null, "World");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
        
        // Test 4: Testing with null (second string)
        try {
            System.out.println("\n=== Test 4: Second String is Null ===");
            concatenate("Hello", null);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
        
        // Test 5: Testing with both null
        try {
            System.out.println("\n=== Test 5: Both Strings are Null ===");
            concatenate(null, null);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
        
        // Test 6: Safe concatenation with nulls
        try {
            System.out.println("\n=== Test 6: Safe Concatenation (handles nulls) ===");
            String result6 = safeConcatenate(null, "World");
            System.out.println("Result with first null: '" + result6 + "'");
            
            String result7 = safeConcatenate("Hello", null);
            System.out.println("Result with second null: '" + result7 + "'");
            
            String result8 = safeConcatenate(null, null);
            System.out.println("Result with both null: '" + result8 + "'");
            
        } catch (Exception e) {
            System.out.println("Error in safe concatenation: " + e.getMessage());
        }
    }
}
