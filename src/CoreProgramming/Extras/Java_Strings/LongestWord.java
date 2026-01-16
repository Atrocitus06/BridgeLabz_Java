package core_programming.Extras.Java_Strings;
/*
5. Find the Longest Word in a Sentence
Problem:
Write a Java program that takes a sentence as input and returns the longest word in the
sentence.
*/

import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String word = "";
        String longestWord = "";

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            if (ch != ' ') {
                word = word + ch;
            } else {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
                word = "";
            }
        }

        if (word.length() > longestWord.length()) {
            longestWord = word;
        }

        System.out.println("Longest word: " + longestWord);
    }
}

