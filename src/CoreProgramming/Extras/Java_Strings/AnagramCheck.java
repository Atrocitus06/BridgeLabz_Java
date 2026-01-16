package core_programming.Extras.Java_Strings;
/*
11. Write a Java program that accepts two strings from the user and checks if the two
strings are anagrams of each other (i.e., whether they contain the same characters in any
order).
*/

import java.util.Scanner;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        // remove spaces and convert to lowercase
        String str1 = "";
        String str2 = "";

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != ' ') {
                char ch = s1.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    ch = (char)(ch + 32);
                }
                str1 = str1 + ch;
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) != ' ') {
                char ch = s2.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    ch = (char)(ch + 32);
                }
                str2 = str2 + ch;
            }
        }

        if (str1.length() != str2.length()) {
            System.out.println("The strings are NOT anagrams");
            return;
        }

        boolean isAnagram = true;

        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            int count1 = 0, count2 = 0;

            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) == ch) count1++;
                if (str2.charAt(j) == ch) count2++;
            }

            if (count1 != count2) {
                isAnagram = false;
                break;
            }
        }

        if (isAnagram) {
            System.out.println("The strings are anagrams");
        } else {
            System.out.println("The strings are NOT anagrams");
        }
    }
}
