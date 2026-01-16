package core_programming.ProgrammingElements.Level2;/*
Write an ProgrammingElements.Level2.IntOperation program by taking a, b, and c as input values and print the following integer operations a + b *c, a * b + c, c + a / b, and a % b + c. Please also understand the precedence of the operators.
Hint =>
Create variables a, b, c of int data type.
Take user input for a, b, and c.
Compute 3 integer operations and assign result to a variable
Finally print the result and try to understand operator precedence.
I/P => fee, discountPrecent
O/P => The results of Int Operations are —-, -—, and —-
*/

import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a;
        int b;
        int c;
        int result1;
        int result2;
        int result3;
        int result4;

        System.out.print("Enter value of a: ");
        a = input.nextInt();

        System.out.print("Enter value of b: ");
        b = input.nextInt();

        System.out.print("Enter value of c: ");
        c = input.nextInt();

        result1 = a + b * c;
        result2 = a * b + c;
        result3 = c + a / b;
        result4 = a % b + c;

        System.out.println(
                "The results of Int Operations are " +
                        result1 + ", " + result2 + ", " + result3 + ", and " + result4
        );
    }
}
