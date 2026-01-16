package core_programming.String.Level2;
/*
Write a program to find and return the length of a string without using the length() method
Hint =>
Take user input using the Scanner next() method
Create a method to find and return a string's length without using the built-in length() method. The logic for this is to use the infinite loop to count each character till the charAt() method throws a runtime exception, handles the exception, and then return the count
The main function calls the user-defined method as well as the built-in length() method and displays the result
*/

import java.util.Scanner;

public class StringLengthDemo {

    static int findLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        int len1 = findLength(text);
        int len2 = text.length();

        System.out.println("Length without using length(): " + len1);
        System.out.println("Length using length(): " + len2);

        sc.close();
    }
}
