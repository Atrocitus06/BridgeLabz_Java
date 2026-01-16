package core_programming.ControlFlowPractices.Level3;/*
Create a program to count the number of digits in an integer.
Hint =>
Get an integer input for the number variable.
Create an integer variable count with value 0.
Use a loop to iterate until number is not equal to 0.
Remove the last digit from number in each iteration
Increase count by 1 in each iteration.
Finally display the count to show the number of digits
*/

import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number;
        int count = 0;

        System.out.print("Enter an integer: ");
        number = input.nextInt();

        if (number == 0) {
            count = 1;   // special case for 0
        } else {

            while (number != 0) {
                number = number / 10; // remove last digit
                count++;              // increase count
            }
        }

        System.out.println("Number of digits = " + count);
    }
}
