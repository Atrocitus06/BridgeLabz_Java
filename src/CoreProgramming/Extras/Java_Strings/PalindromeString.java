package core_programming.Extras.Java_Strings;
/*
3. Palindrome String Check
Problem:
Write a Java program to check if a given string is a palindrome (a string that reads the
same forward and backward).
*/

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }

        // check palindrome
        if (str.equals(reverse)) {
            System.out.println("The string is a Palindrome");
        } else {
            System.out.println("The string is NOT a Palindrome");
        }
    }
}

