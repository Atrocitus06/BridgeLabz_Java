package core_programming.String.Level1;
/*
Write a program to convert the complete text to uppercase and compare the results
Hint =>
Take user input using the  Scanner nextLine() method to take the complete text into a String variable
Write a method using the String built-in charAt() method to convert each character if it is lowercase to the uppercase. Use the logic ASCII value of 'a' is 97 and 'A' is 65 so the difference is 32, similarly ASCII value of 'b' is 98 and 'B' is 66 so the difference is 32, and so on
Write a method to compare two strings using the charAt() method and return a boolean result
In the main() use the String built-in method toUpperCase() to get the uppercase text and compare the two strings using the user-defined method. And finally display the result
*/

import java.util.Scanner;

public class UpperCaseCompare {

    static String toUpperCaseUsingCharAt(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32); // ASCII conversion
            }

            result = result + ch;
        }
        return result;
    }

    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String upper1 = toUpperCaseUsingCharAt(text);

        String upper2 = text.toUpperCase();

        boolean result = compareStrings(upper1, upper2);

        System.out.println("Uppercase using charAt(): " + upper1);
        System.out.println("Uppercase using toUpperCase(): " + upper2);
        System.out.println("Are both results equal? " + result);

        sc.close();
    }
}

