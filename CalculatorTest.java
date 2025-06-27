import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
public class CalculatorTest {
   private Calculator calculator;
    @Before
    public void setUp() {
        System.out.println("Setting up Calculator instance...");
        calculator = new Calculator();
    }
    @After
    public void tearDown() {
        System.out.println("Cleaning up Calculator instance...\n");
        calculator = null;
    }
    @Test
    public void testAddition() {
        int a = 4;
        int b = 5;
        int result = calculator.add(a, b);
        assertEquals(9, result);
    }

    @Test
    public void testSubtraction() {
        int a = 10;
        int b = 6;
        int result = calculator.subtract(a, b);
        assertEquals(4, result);
    }
    static class Calculator {
        public int add(int x, int y) {
            return x + y;
        }

        public int subtract(int x, int y) {
            return x - y;
        }
    }
}

