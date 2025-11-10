import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DivideTwoNumbersTest {

    // Test for dividing two positive numbers
    @Test
    public void testDividePositiveNumbers() {
        assertEquals(5.0, DivideTwoNumbers.divide(20.0, 4.0), 0.0001);
        assertEquals(2.5, DivideTwoNumbers.divide(10.0, 4.0), 0.0001);
    }

    // Test for dividing two negative numbers
    @Test
    public void testDivideNegativeNumbers() {
        assertEquals(5.0, DivideTwoNumbers.divide(-20.0, -4.0), 0.0001);
    }

    // Test for dividing positive by negative number
    @Test
    public void testDividePositiveByNegative() {
        assertEquals(-5.0, DivideTwoNumbers.divide(20.0, -4.0), 0.0001);
    }

    // Test for dividing negative by positive number
    @Test
    public void testDivideNegativeByPositive() {
        assertEquals(-5.0, DivideTwoNumbers.divide(-20.0, 4.0), 0.0001);
    }

    // Test for dividing by zero - should throw ArithmeticException
    @Test
    public void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            DivideTwoNumbers.divide(10.0, 0.0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    // Test for dividing zero by a non-zero number
    @Test
    public void testDivideZeroByNumber() {
        assertEquals(0.0, DivideTwoNumbers.divide(0.0, 5.0), 0.0001);
    }

    // Test for dividing by one
    @Test
    public void testDivideByOne() {
        assertEquals(10.0, DivideTwoNumbers.divide(10.0, 1.0), 0.0001);
        assertEquals(-7.5, DivideTwoNumbers.divide(-7.5, 1.0), 0.0001);
    }

    // Test for dividing one by a number
    @Test
    public void testDivideOneByNumber() {
        assertEquals(0.5, DivideTwoNumbers.divide(1.0, 2.0), 0.0001);
        assertEquals(0.25, DivideTwoNumbers.divide(1.0, 4.0), 0.0001);
    }

    // Test for dividing same numbers
    @Test
    public void testDivideSameNumbers() {
        assertEquals(1.0, DivideTwoNumbers.divide(5.0, 5.0), 0.0001);
        assertEquals(1.0, DivideTwoNumbers.divide(100.0, 100.0), 0.0001);
    }

    // Test for dividing decimal numbers
    @Test
    public void testDivideDecimalNumbers() {
        assertEquals(2.5, DivideTwoNumbers.divide(5.5, 2.2), 0.0001);
        assertEquals(3.333, DivideTwoNumbers.divide(10.0, 3.0), 0.001);
    }

    // Test for dividing large numbers
    @Test
    public void testDivideLargeNumbers() {
        assertEquals(1000.0, DivideTwoNumbers.divide(1000000.0, 1000.0), 0.0001);
    }

    // Test for dividing very small numbers
    @Test
    public void testDivideSmallNumbers() {
        assertEquals(2.0, DivideTwoNumbers.divide(0.002, 0.001), 0.0001);
    }
}
