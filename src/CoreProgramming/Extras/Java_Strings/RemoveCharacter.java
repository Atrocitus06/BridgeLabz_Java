package core_programming.Extras.Java_Strings;
/*
10. Remove a Specific Character from a String
Problem:
Write a Java program to remove all occurrences of a specific character from a string.
Example Input:
String: "Hello World"
Character to Remove: 'l'

Expected Output:
Modified String: "Heo Word"
*/

import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.print("Enter character to remove: ");
        char removeChar = sc.next().charAt(0);

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != removeChar) {
                result = result + str.charAt(i);
            }
        }

        System.out.println("Modified String: " + result);
    }
}
