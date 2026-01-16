package core_programming.Extras.Java_Strings;
/*
4. Remove Duplicates from a String
Problem:
Write a Java program to remove all duplicate characters from a given string and return
the modified string.
 */

import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            boolean found = false;
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == ch) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                result = result + ch;
            }
        }

        System.out.println("String after removing duplicates: " + result);
    }
}
