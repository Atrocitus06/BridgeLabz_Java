package core_programming.Extras.Built_in_Functions;
/*
8. Temperature Converter:
○ Write a program that converts temperatures between Fahrenheit and Celsius. ○
The program should have separate functions for converting from Fahrenheit to
Celsius and from Celsius to Fahrenheit.
 */

import java.util.Scanner;

public class TemperatureConverter {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter temperature in Celsius: ");
            double c = sc.nextDouble();
            System.out.println("Temperature in Fahrenheit: " + celsiusToFahrenheit(c));
        }
        else if (choice == 2) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double f = sc.nextDouble();
            System.out.println("Temperature in Celsius: " + fahrenheitToCelsius(f));
        }
        else {
            System.out.println("Invalid choice");
        }
    }
}
