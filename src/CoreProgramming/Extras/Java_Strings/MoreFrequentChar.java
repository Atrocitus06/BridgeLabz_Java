package core_programming.Extras.Java_Strings;
/*
9. Find the Most Frequent Character
Problem:
Write a Java program to find the most frequent character in a string.
Example Input:
String: "success"

Expected Output:
Most Frequent Character: 's'
*/

import java.util.Scanner;

public class MoreFrequentChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        char mostFreqChar = str.charAt(0);
        int maxCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int count = 0;

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ch) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mostFreqChar = ch;
            }
        }

        System.out.println("Most Frequent Character: '" + mostFreqChar + "'");
    }
}
