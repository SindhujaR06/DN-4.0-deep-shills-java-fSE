

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTestApp {
    static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }
    }
    public static class CalculatorTest {

        @Test
        public void testAdd() {
            Calculator calc = new Calculator();
            int result = calc.add(5, 3);
            assertEquals(8, result);
        }

        @Test
        public void testSubtract() {
            Calculator calc = new Calculator();
            int result = calc.subtract(5, 3);
            assertEquals(2, result);
        }
    }
}

