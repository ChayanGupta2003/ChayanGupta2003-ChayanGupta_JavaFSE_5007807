
import java.util.Scanner;

public class Forecast {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter initial value: ");
        double initialValue = scanner.nextDouble();
        
        System.out.print("Enter growth rate (as a decimal): ");
        double growthRate = scanner.nextDouble();
        
        System.out.print("Enter number of periods: ");
        int periods = scanner.nextInt();
        
        double futureValue = calculateFutureValue(initialValue, growthRate, periods);
        
        System.out.println("Future value: " + futureValue);
    }

    public static double calculateFutureValue(double value, double rate, int period) {
        if (period == 0) {
            return value;
        }
        return calculateFutureValue(value * (1 + rate), rate, period - 1);
    }
}
