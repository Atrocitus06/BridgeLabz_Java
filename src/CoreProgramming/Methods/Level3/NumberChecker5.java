package core_programming.Methods.Level3;
/*
Extend or Create a NumberChecker utility class and perform following task.
Call from main() method the different methods and display results. Make sure all are
static methods
Hint =>
Method to find factors of a number and return them as an array. Note there are 2
for loops one for the count and another for finding the factor and storing in the array
Method to find the greates factor of a Number using the factors array
Method to find the sum of the factors using factors array and return the sum
Method to find the product of the factors using factors array and return the product
Method to find product of cube of the factors using the factors array. Use Math.pow()
Method to Check if a number is a perfect number. Perfect numbers are positive integers
that are equal to the sum of their proper divisors
Method to find the number is a abundant number. A number is called an abundant number
if the sum of its proper divisors is greater than the number itself
Method to find the number is a deficient number. A number is called a deficient number
if the sum of its proper divisors is less than the number itself
Method to Check if a number is a strong number. A number is called a strong number
if the sum of the factorial of its digits is equal to the number itself

 */

import java.util.Scanner;

public class NumberChecker5 {

    public static int[] findFactors(int number) {

        int count = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    public static int findGreatestFactor(int[] factors) {
        int max = factors[0];
        for (int f : factors) {
            if (f > max) {
                max = f;
            }
        }
        return max;
    }

    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) {
            sum += f;
        }
        return sum;
    }

    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors) {
            product *= f;
        }
        return product;
    }

    public static double productOfCubeOfFactors(int[] factors) {
        double product = 1;
        for (int f : factors) {
            product *= Math.pow(f, 3);
        }
        return product;
    }

    public static boolean isPerfectNumber(int number, int[] factors) {
        int sum = 0;
        for (int f : factors) {
            if (f != number) {   // proper divisors
                sum += f;
            }
        }
        return sum == number;
    }

    public static boolean isAbundantNumber(int number, int[] factors) {
        int sum = 0;
        for (int f : factors) {
            if (f != number) {
                sum += f;
            }
        }
        return sum > number;
    }

    public static boolean isDeficientNumber(int number, int[] factors) {
        int sum = 0;
        for (int f : factors) {
            if (f != number) {
                sum += f;
            }
        }
        return sum < number;
    }

    public static boolean isStrongNumber(int number) {

        int temp = number;
        int sum = 0;

        while (temp != 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }

        return sum == number;
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] factors = findFactors(number);

        System.out.print("Factors: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }
        System.out.println();

        System.out.println("Greatest Factor: " + findGreatestFactor(factors));
        System.out.println("Sum of Factors: " + sumOfFactors(factors));
        System.out.println("Product of Factors: " + productOfFactors(factors));
        System.out.println("Product of Cube of Factors: " + productOfCubeOfFactors(factors));

        System.out.println("Is Perfect Number: " + isPerfectNumber(number, factors));
        System.out.println("Is Abundant Number: " + isAbundantNumber(number, factors));
        System.out.println("Is Deficient Number: " + isDeficientNumber(number, factors));
        System.out.println("Is Strong Number: " + isStrongNumber(number));

        sc.close();
    }
}
