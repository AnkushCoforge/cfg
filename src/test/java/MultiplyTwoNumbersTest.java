import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MultiplyTwoNumbersTest {

    // Test for multiplying two positive numbers
    @Test
    public void testMultiplyPositiveNumbers() {
        assertEquals(40, MultiplyTwoNumbers.multiply(5, 8));
    }

    // Test for multiplying two negative numbers
    @Test
    public void testMultiplyNegativeNumbers() {
        assertEquals(20, MultiplyTwoNumbers.multiply(-4, -5));
    }

    // Test for multiplying positive and negative numbers
    @Test
    public void testMultiplyPositiveAndNegative() {
        assertEquals(-30, MultiplyTwoNumbers.multiply(6, -5));
        assertEquals(-24, MultiplyTwoNumbers.multiply(-8, 3));
    }

    // Test for multiplying with zero
    @Test
    public void testMultiplyWithZero() {
        assertEquals(0, MultiplyTwoNumbers.multiply(0, 5));
        assertEquals(0, MultiplyTwoNumbers.multiply(10, 0));
        assertEquals(0, MultiplyTwoNumbers.multiply(0, 0));
    }

    // Test for multiplying by one
    @Test
    public void testMultiplyByOne() {
        assertEquals(7, MultiplyTwoNumbers.multiply(7, 1));
        assertEquals(15, MultiplyTwoNumbers.multiply(1, 15));
    }

    // Test for multiplying large numbers
    @Test
    public void testMultiplyLargeNumbers() {
        assertEquals(1000000, MultiplyTwoNumbers.multiply(1000, 1000));
    }

    // Test for multiplying same numbers
    @Test
    public void testMultiplySameNumbers() {
        assertEquals(25, MultiplyTwoNumbers.multiply(5, 5));
        assertEquals(100, MultiplyTwoNumbers.multiply(10, 10));
    }

    // Test for commutative property (a * b = b * a)
    @Test
    public void testCommutativeProperty() {
        assertEquals(MultiplyTwoNumbers.multiply(3, 7), MultiplyTwoNumbers.multiply(7, 3));
        assertEquals(MultiplyTwoNumbers.multiply(12, 4), MultiplyTwoNumbers.multiply(4, 12));
    }
}
