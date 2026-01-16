package core_programming.String.Level2;
/*
Rock-Paper-Scissors is a game played between a minimum of two players. Each player can choose either rock, paper, or scissors. Here the game is played between a user and a computer. Based on the rules, either a player or a computer will win. Show the stats of player and computer win in a tabular format across multiple games. Also, show the winning percentage between the player and the computer.
Hint =>
The rule is: rock-scissors: rock will win (rock crushes scissors); rock-paper: paper wins (paper covers rock); scissors-paper: scissors win (scissors cuts paper)
Create a Method to find the Computer Choice using the Math.random
Create a Method to find the winner between the user and the computer
Create a Method to find the average and percentage of wins for the user and the computer and return a String 2D array
Create a Method to display the results of every game and also display the average and percentage wins
In the main take user input for the number of games and call methods to display results
*/

import java.util.Scanner;

public class RockPaperScissors {

    static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);

        if (choice == 0)
            return "Rock";
        else if (choice == 1)
            return "Paper";
        else
            return "Scissors";
    }

    static String findWinner(String user, String computer) {

        if (user.equals(computer))
            return "Draw";

        if (user.equals("Rock") && computer.equals("Scissors"))
            return "User";
        if (user.equals("Scissors") && computer.equals("Paper"))
            return "User";
        if (user.equals("Paper") && computer.equals("Rock"))
            return "User";

        return "Computer";
    }

    static String[][] calculateStats(int userWins, int computerWins, int games) {

        String[][] stats = new String[2][3];

        double userPercent = (userWins * 100.0) / games;
        double computerPercent = (computerWins * 100.0) / games;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", userPercent);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", computerPercent);

        return stats;
    }

    static void displayResults(String[][] games, String[][] stats) {

        System.out.println("\nGAME RESULTS");
        System.out.println("Game\tUser\tComputer\tWinner");

        for (int i = 0; i < games.length; i++) {
            System.out.println((i + 1) + "\t" +
                    games[i][0] + "\t" +
                    games[i][1] + "\t\t" +
                    games[i][2]);
        }

        System.out.println("\nFINAL STATISTICS");
        System.out.println("Player\tWins\tWin %");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" +
                    stats[i][1] + "\t" +
                    stats[i][2] + "%");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int n = sc.nextInt();

        String[][] gameResults = new String[n][3];

        int userWins = 0;
        int computerWins = 0;

        for (int i = 0; i < n; i++) {

            System.out.print("\nGame " + (i + 1) + " - Enter your choice (Rock/Paper/Scissors): ");
            String userChoice = sc.next();
            userChoice = userChoice.substring(0, 1).toUpperCase() +
                    userChoice.substring(1).toLowerCase();

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("User"))
                userWins++;
            else if (winner.equals("Computer"))
                computerWins++;

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }

        String[][] stats = calculateStats(userWins, computerWins, n);
        displayResults(gameResults, stats);

        sc.close();
    }
}
