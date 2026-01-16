package core_programming.Methods.Level2;
/*
Extend or Create a UnitConvertor utility class similar to the one shown in the
notes to do the following.  Please define static methods for all the UnitConvertor
class methods. E.g.
public static double convertFarhenheitToCelsius(double farhenheit) =>
Method to convert Fahrenheit to Celsius and return the value. Use the following code
double farhenheit2celsius = (farhenheit - 32) * 5 / 9;
Method to convert Celsius to Fahrenheit and return the value. Use the following code
double celsius2farhenheit = (celsius * 9 / 5) + 32;
Method to convert pounds to kilograms and return the value. Use the following code
double pounds2kilograms = 0.453592;
Method to convert kilograms to pounds and return the value. Use the following code
double kilograms2pounds = 2.20462;
Method to convert gallons to liters and return the value. Use following code to convert
double gallons2liters = 3.78541;
Method to convert liters to gallons and return the value. Use following code to convert
double liters2gallons = 0.264172;
*/

public class UnitConvertor3 {

    public static double convertFarhenheitToCelsius(double farhenheit) {
        double farhenheit2celsius = (farhenheit - 32) * 5 / 9;
        return farhenheit2celsius;
    }

    public static double convertCelsiusToFarhenheit(double celsius) {
        double celsius2farhenheit = (celsius * 9 / 5) + 32;
        return celsius2farhenheit;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {

        System.out.println("98.6 F in Celsius: " + convertFarhenheitToCelsius(98.6));
        System.out.println("37 C in Fahrenheit: " + convertCelsiusToFarhenheit(37));
        System.out.println("150 pounds in kilograms: " + convertPoundsToKilograms(150));
        System.out.println("68 kilograms in pounds: " + convertKilogramsToPounds(68));
        System.out.println("5 gallons in liters: " + convertGallonsToLiters(5));
        System.out.println("10 liters in gallons: " + convertLitersToGallons(10));
    }
}
