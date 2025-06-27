public class FinancialForecast {
        public static double futureValueRecursive(double presentValue, double rate, int years) {
            if (years == 0)
                return presentValue; 
            return futureValueRecursive(presentValue * (1 + rate), rate, years - 1);
        }
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
            double futureRecursive = futureValueRecursive(presentValue, growthRate, years);
            System.out.printf("Recursive Future Value after %d years: Rs.%.2f%n", years, futureRecursive);
            double futureIterative = futureValueIterative(presentValue, growthRate, years);
            System.out.printf("Iterative Future Value after %d years: Rs.%.2f%n", years, futureIterative
    }
    
