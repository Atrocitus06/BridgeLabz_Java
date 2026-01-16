package core_programming.Extras.Java_Strings;
/*
6. Find Substring Occurrences
Problem:
Write a Java program to count how many times a given substring occurs in a string.
*/

import java.util.Scanner;

public class SubstringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String str = sc.nextLine();

        System.out.print("Enter the substring: ");
        String sub = sc.nextLine();

        int count = 0;

        for (int i = 0; i <= str.length() - sub.length(); i++) {
            boolean match = true;

            for (int j = 0; j < sub.length(); j++) {
                if (str.charAt(i + j) != sub.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                count++;
            }
        }

        System.out.println("Substring occurs " + count + " times");
    }
}
