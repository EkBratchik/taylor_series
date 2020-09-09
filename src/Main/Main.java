package Main;

import com.sun.media.sound.InvalidFormatException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter k ");
            int k = scanner.nextInt();
            System.out.println("Enter x [-1,1) ");
            double x = scanner.nextDouble();
            if (x < -1 || x >= 1) {
                throw new InvalidFormatException("x should be [-1,1)");
            }
            double eps = Math.pow(10, -k);
            double actualValue = calculateActualValue(x);
            double calculatedValue = calculateTailorSeries(eps, x);
            System.out.println("Actual value: " + formattedNumericValue(actualValue));
            System.out.println("Calculated value: " + formattedNumericValue(calculatedValue));
        } catch (Exception ex) {
            System.out.println("Error while reading value: " + ex);
        }
    }

    static double calculateActualValue(double x) {
        return Math.log(1 - x);
    }

    static double calculateTailorSeries(double eps, double x) {
        double elem = 100;
        double calculatedValue = 0;
        int n = 1;
        while (Math.abs(elem) >= Math.abs(eps)) {
            elem = -(Math.pow(x, n) / n);
            calculatedValue += elem;
            n++;
        }
        return calculatedValue;
    }

    private static String formattedNumericValue(double value) {
        return String.format("%.3f", value);
    }

}
