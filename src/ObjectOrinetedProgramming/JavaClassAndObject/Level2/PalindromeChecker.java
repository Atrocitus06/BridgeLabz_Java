package ObjectOrientedProgramming.JavaClassAndObject.Level2;
// Package declaration that organizes this class within the ObjectOrientedProgramming.JavaClassAndObject.Level2 namespace.

import java.util.Scanner;
// Importing Scanner class to read user input from the console.

class PalindromeChecker {
// Class declaration for PalindromeChecker to encapsulate palindrome checking functionality.

    String text;
// Instance variable to store the input text string to check for palindrome property.

    boolean isPalindrome() {
// Method declaration that checks and returns whether the text is a palindrome.

        int start = 0;
// Initializing start index to 0 (beginning of string).

        int end = text.length() - 1;
// Initializing end index to last character position (length - 1).

        while (start < end) {
// Looping while start pointer hasn't crossed end pointer.

            if (text.charAt(start) != text.charAt(end)) {
// Comparing characters at start and end positions.

                return false;
// Returning false immediately if mismatch found (not palindrome).

            } // End of if check for character mismatch.

            start++;
// Incrementing start pointer to move inward from beginning.

            end--;
            // Decrementing end pointer to move inward from end.

        } // End of while loop for two-pointer traversal.

        return true;
// Returning true if loop completes (all matching pairs checked).

    } // End of isPalindrome method.

    void displayResult() {
// Method declaration to display whether the text is a palindrome or not.

        if (isPalindrome())
// Calling isPalindrome() and checking if true.

            System.out.println("The string is a Palindrome");
// Printing affirmative message if palindrome confirmed.

        else
// Else case when not a palindrome.

            System.out.println("The string is NOT a Palindrome");
// Printing negative message if not palindrome.

    } // End of displayResult method.

    public static void main(String[] args) {
// Main method: entry point of the program where execution begins.

        Scanner sc = new Scanner(System.in);
// Creating a Scanner object named 'sc' to read input from System.in (keyboard).

        PalindromeChecker pc = new PalindromeChecker();
// Creating a new PalindromeChecker object instance named 'pc' using default constructor.

        System.out.print("Enter a string: ");
// Prompting the user to enter a string to check.

        pc.text = sc.nextLine();
// Reading a line of input (string) and assigning it to the object's text field.

        pc.displayResult();
// Calling displayResult method on 'pc' object to check and print result.

        sc.close(); // Closing the Scanner to prevent resource leak (good practice).
    } // End of main method.

} // End of PalindromeChecker class.
