package core_programming.Extras.Built_in_Functions;
/*
3. Prime Number Checker:
○ Create a program that checks whether a given number is a prime number. ○
The program should use a separate function to perform the prime check and
return the result.
 */

import java.util.Scanner;

public class PrimeChecker {

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is NOT a Prime Number");
        }
    }
}
