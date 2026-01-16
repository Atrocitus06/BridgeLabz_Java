package core_programming.String.Level3;
/*
Write a program to find the frequency of characters in a string using the charAt() method and display the result
Hint =>
Create a method to find the frequency of characters in a string using the charAt() method and return the characters and their frequencies in a 2D array. The logic used here is as follows:
Create an array to store the frequency of characters in the text. ASCII values of characters are used as indexes in the array to store the frequency of each character. There are 256 ASCII characters
Loop through the text to find the frequency of characters in the text
Create an array to store the characters and their frequencies
Loop through the characters in the text and store the characters and their frequencies
In the main function take user inputs, call user-defined methods, and displays result.
*/

import java.util.Scanner;

public class CharacterFrequency {

    public static Object[][] findFrequency(String text) {

        int[] freq = new int[256]; // ASCII characters

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] != 0) {
                count++;
                freq[ch] = -freq[ch]; // mark as counted
            }
        }

        Object[][] result = new Object[count][2];

        for (int i = 0; i < 256; i++) {
            if (freq[i] < 0) {
                freq[i] = -freq[i];
            }
        }

        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (freq[ch] != 0) {
                result[index][0] = ch;
                result[index][1] = freq[ch];
                freq[ch] = 0; // avoid duplicate entry
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        Object[][] result = findFrequency(text);

        System.out.println("\nCharacter\tFrequency");
        System.out.println("----------------------");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t\t" + result[i][1]);
        }

        sc.close();
    }
}
