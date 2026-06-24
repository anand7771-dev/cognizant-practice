package dsa;

public class FinancialForecast {

    // Recursive method to calculate future value
    // futureValue = presentValue * (1 + growthRate)^years
    static double forecast(double presentValue, double growthRate, int years) {
        if (years == 0) return presentValue;
        return forecast(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double value = forecast(1000.0, 0.05, 3);
        System.out.println("Future Value: " + value);
    }
}