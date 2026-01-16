package core_programming.Extras.Built_in_Functions;
/*
1. Number Guessing Game:
○ Write a Java program where the user thinks of a number between 1 and 100, and
the computer tries to guess the number by generating random guesses.
○ The user provides feedback by indicating whether the guess is high, low, or
correct. The program should be modular, with different functions for generating
guesses, receiving user feedback, and determining the next guess.
 */

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static int generateGuess(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
    public static String getFeedback(Scanner sc) {
        System.out.print("Is the guess High, Low, or Correct? (H/L/C): ");
        return sc.next().toUpperCase();
    }

    public static int[] updateRange(String feedback, int guess, int min, int max) {
        if (feedback.equals("H")) {
            max = guess - 1;
        } else if (feedback.equals("L")) {
            min = guess + 1;
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int min = 1;
        int max = 100;
        String feedback;
        int guess;

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");

        while (true) {
            guess = generateGuess(min, max);
            System.out.println("My guess is: " + guess);

            feedback = getFeedback(sc);

            if (feedback.equals("C")) {
                System.out.println("Yay! I guessed your number correctly 🎉");
                break;
            }

            int[] range = updateRange(feedback, guess, min, max);
            min = range[0];
            max = range[1];
        }
    }
}
