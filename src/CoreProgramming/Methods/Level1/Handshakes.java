package core_programming.Methods.Level1;
/*
Create a program to find the maximum number of handshakes among N number of students.
Hint =>
Get integer input for number of students
Use the combination = (n * (n - 1)) / 2 formula to calculate the maximum number of
possible handshakes.
Write a method to use the combination formulae to calculate the number of handshakes
*/

import java.util.Scanner;

public class Handshakes {

    static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int handshakes = calculateHandshakes(n);

        System.out.println("Maximum number of handshakes among "
                + n + " students is: " + handshakes);

        sc.close();
    }
}
