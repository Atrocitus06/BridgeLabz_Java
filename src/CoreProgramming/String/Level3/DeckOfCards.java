package core_programming.String.Level3;
/*
Write a program to create a deck of cards, initialize the deck, shuffle the deck, and distribute the deck of n cards to x number of players. Finally, print the cards the players have.
Hint =>
Create a deck of cards with suits "Hearts", "Diamonds", "Clubs", "Spades" and ranks from "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", and "Ace"
Calculate the number of cards in the deck and initialize the deck
int numOfCards = suits.length * ranks.length;
Write a Method to Initialize the deck of cards with suits and ranks and return the deck. The deck is an array of strings where each string represents a card in the deck represented as "rank of suit" e.g., "2 of Hearts"
Write a Method to Shuffle the deck of cards and return the shuffled deck. To shuffle the card iterate over the deck and swap each card with a random card from the remaining deck to shuffle the deck. Please find the steps below
Step1: Use for Loop Iterate over the deck and swap each card with a random card from the remaining deck
Step 2: Inside the Loop Generate a random card number between i and n using the following code
int randomCardNumber = i + (int) (Math.random() * (n - i));
Step 3: Swap the current card with the random card
Write a Method to distribute the deck of n cards to x number of players and return the players. For this Check the n cards can be distributed to x players. If possible then Create a 2D array to store the players and their cards
Write a Method to Print the players and their cards
*/

import java.util.Scanner;

public class DeckOfCards {

    public static String[] initializeDeck(String[] suits, String[] ranks) {

        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }

        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {

        int n = deck.length;

        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int)(Math.random() * (n - i));

            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }

        return deck;
    }

    public static String[][] distributeCards(String[] deck, int players, int cards) {

        if (players * cards > deck.length) {
            return null;
        }

        String[][] result = new String[players][cards];
        int index = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cards; j++) {
                result[i][j] = deck[index];
                index++;
            }
        }

        return result;
    }

    public static void printPlayers(String[][] playersCards) {

        for (int i = 0; i < playersCards.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + " cards:");
            for (int j = 0; j < playersCards[i].length; j++) {
                System.out.println(playersCards[i][j]);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };

        String[] deck = initializeDeck(suits, ranks);
        deck = shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int players = sc.nextInt();

        System.out.print("Enter number of cards per player: ");
        int cards = sc.nextInt();

        String[][] playersCards = distributeCards(deck, players, cards);

        if (playersCards == null) {
            System.out.println("Cards cannot be distributed!");
        } else {
            printPlayers(playersCards);
        }

        sc.close();
    }
}
