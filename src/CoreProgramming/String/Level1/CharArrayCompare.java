package core_programming.String.Level1;
/*
Write a program to return all the characters in a string using the user-defined method,
compare the result with the String built-in toCharArray() method, and display the result
Hint =>
Take user input using the  Scanner next() method to take the text into a String variable
Write a method to return the characters in a string without using the toCharArray()
Write a method to compare two string arrays and return a boolean result
In the main() call the user-defined method and the String built-in ​​toCharArray()
method, compare the 2 arrays, and finally display the result
*/

import java.util.Scanner;

public class CharArrayCompare {

    static char[] getCharsUsingCharAt(String text) {
        char[] arr = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            arr[i] = text.charAt(i);
        }
        return arr;
    }

    static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] arr1 = getCharsUsingCharAt(text);

        char[] arr2 = text.toCharArray();

        boolean result = compareCharArrays(arr1, arr2);

        System.out.println("Characters returned using charAt():");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }

        System.out.println("\nAre both character arrays equal? " + result);

        sc.close();
    }
}
