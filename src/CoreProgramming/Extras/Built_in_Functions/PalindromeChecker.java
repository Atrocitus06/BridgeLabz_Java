package core_programming.Extras.Built_in_Functions;
/*5. Palindrome Checker:
        ○ Write a program that checks if a given string is a palindrome (a word, phrase, or
        sequence that reads the same backward as forward).
        ○ Break the program into functions for input, checking the palindrome condition,
and displaying the result./*
*/

import java.util.Scanner;

public class PalindromeChecker {

    // Method to take input
    public static String takeInput(Scanner sc) {
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }

    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void displayResult(String str, boolean result) {
        if (result) {
            System.out.println(str + " is a Palindrome");
        } else {
            System.out.println(str + " is NOT a Palindrome");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = takeInput(sc);
        boolean result = isPalindrome(input);
        displayResult(input, result);
    }
}
