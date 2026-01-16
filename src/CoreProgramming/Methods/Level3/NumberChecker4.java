package core_programming.Methods.Level3;
/*
Extend or Create a NumberChecker utility class and perform following task.
Call from main() method the different methods and display results.
Make sure all are static methods
Hint =>
Method to Check if a number is prime number. A prime number is a number greater than 1
that has no positive divisors other than 1 and itself.
Method to Check if a number is a neon number. A neon number is a number where the sum of
digits of the square of the number is equal to the number itself
Method to Check if a number is a spy number. A number is called a spy number if the sum
of its digits is equal to the product of its digits
Method to Check if a number is an automorphic number. An automorphic number is a number
whose square ends with the number itself. E.g. 5 is an automorphic number
Method to Check if a number is a buzz number. A buzz number is a number that is either
divisible by 7 or ends with 7
*/

import java.util.Scanner;

public class NumberChecker4 {

    public static boolean isPrime(int number) {

        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNeonNumber(int number) {

        int square = number * number;
        int sum = 0;

        while (square != 0) {
            sum += square % 10;
            square /= 10;
        }

        return sum == number;
    }

    public static boolean isSpyNumber(int number) {

        int sum = 0;
        int product = 1;
        int temp = number;

        while (temp != 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }

        return sum == product;
    }

    public static boolean isAutomorphic(int number) {

        int square = number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    public static boolean isBuzzNumber(int number) {

        return (number % 7 == 0 || number % 10 == 7);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("Is Prime Number: " + isPrime(number));
        System.out.println("Is Neon Number: " + isNeonNumber(number));
        System.out.println("Is Spy Number: " + isSpyNumber(number));
        System.out.println("Is Automorphic Number: " + isAutomorphic(number));
        System.out.println("Is Buzz Number: " + isBuzzNumber(number));

        sc.close();
    }
}
