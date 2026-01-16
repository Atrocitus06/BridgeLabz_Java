package core_programming.Extras.Java_Strings;
/*
12. Write a replace method in Java that replaces a given word with another word in a
sentence:
*/

import java.util.Scanner;

public class ReplaceWord {

    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String result = "";
        String word = "";

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            if (ch != ' ') {
                word = word + ch;
            } else {
                if (word.equals(oldWord)) {
                    result = result + newWord + " ";
                } else {
                    result = result + word + " ";
                }
                word = "";
            }
        }

        if (word.equals(oldWord)) {
            result = result + newWord;
        } else {
            result = result + word;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        System.out.print("Enter word to replace: ");
        String oldWord = sc.next();

        System.out.print("Enter new word: ");
        String newWord = sc.next();

        String output = replaceWord(sentence, oldWord, newWord);
        System.out.println("Modified Sentence: " + output);
    }
}
