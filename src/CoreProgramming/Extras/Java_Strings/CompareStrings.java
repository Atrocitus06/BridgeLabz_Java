package core_programming.Extras.Java_Strings;
/*
8. Compare Two Strings

Problem:
Write a Java program to compare two strings lexicographically (dictionary order) without
using built-in compare methods.
Example Input:
String 1: "apple"
String 2: "banana"

Expected Output:
"apple" comes before "banana" in lexicographical order
*/

import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int minLength = s1.length() < s2.length() ? s1.length() : s2.length();
        boolean isDifferent = false;

        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
                isDifferent = true;
                break;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                System.out.println("\"" + s1 + "\" comes after \"" + s2 + "\" in lexicographical order");
                isDifferent = true;
                break;
            }
        }

        if (!isDifferent) {
            if (s1.length() < s2.length()) {
                System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
            } else if (s1.length() > s2.length()) {
                System.out.println("\"" + s1 + "\" comes after \"" + s2 + "\" in lexicographical order");
            } else {
                System.out.println("Both strings are equal");
            }
        }
    }
}

