public class FinancialForecast {

        /*
         Recursion is a technique where a method calls itself.
         It's useful when a problem can be broken into smaller subproblems.
         In financial forecasting, we can use it to calculate compound growth.
         Formula: FutureValue = PresentValue × (1 + rate) ^ years
        */
    
        // Recursive method to calculate future value
        public static double futureValueRecursive(double presentValue, double rate, int years) {
            if (years == 0)
                return presentValue; 
            return futureValueRecursive(presentValue * (1 + rate), rate, years - 1);
        }
    
        // Optimized Iterative method (no stack overhead)
        public static double futureValueIterative(double presentValue, double rate, int years) {
            for (int i = 0; i < years; i++) {
                presentValue *= (1 + rate);
            }
            return presentValue;
        }
    
        public static void main(String[] args) {
            double presentValue = 10000;   
            double growthRate = 0.10;      
            int years = 5;                 
    
            // Recursive forecast
            double futureRecursive = futureValueRecursive(presentValue, growthRate, years);
            System.out.printf("Recursive Future Value after %d years: Rs.%.2f%n", years, futureRecursive);
            // Iterative forecast
            double futureIterative = futureValueIterative(presentValue, growthRate, years);
            System.out.printf("Iterative Future Value after %d years: Rs.%.2f%n", years, futureIterative);
            
            /*
             Time Complexity: O(n) for both recursive and iterative versions
             Space Complexity:
               - Recursive: O(n) due to call stack
               - Iterative: O(1)
             In large-scale systems, prefer iterative or memoized versions to avoid stack overflow
            */
        }
    }
    
