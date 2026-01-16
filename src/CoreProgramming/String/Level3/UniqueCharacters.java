package core_programming.String.Level3;
/*
Find unique characters in a string using the charAt() method and display the result
Hint =>
Create a Method to find the length of the text without using the String method length()
Create a method to Find unique characters in a string using the charAt() method and return them as a 1D array. The logic used here is as follows:
Create an array to store the unique characters in the text. The size is the length of the text
Loops to Find the unique characters in the text. Find the unique characters in the text using a nested loop. An outer loop iterates through each character and an inner loop checks if the character is unique by comparing it with the previous characters. If the character is unique, it is stored in the result array
Create a new array to store the unique characters
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result.
*/

import java.util.Scanner;

public class UniqueCharacters {

    public static int findLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {

        }

        return count;
    }

    public static char[] findUniqueCharacters(String text) {

        int length = findLength(text);
        char[] temp = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char[] uniqueChars = findUniqueCharacters(text);

        System.out.println("Unique characters are:");
        for (int i = 0; i < uniqueChars.length; i++) {
            System.out.print(uniqueChars[i] + " ");
        }

        sc.close();
    }
}
