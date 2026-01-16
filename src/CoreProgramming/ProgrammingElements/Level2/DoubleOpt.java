package core_programming.ProgrammingElements.Level2;/*Similarly, write the ProgrammingElements.Level2.DoubleOpt program by
taking double values and doing the same operations.
*/

import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double a;
        double b;
        double c;
        double result1;
        double result2;
        double result3;
        double result4;

        System.out.print("Enter value of a: ");
        a = input.nextDouble();

        System.out.print("Enter value of b: ");
        b = input.nextDouble();

        System.out.print("Enter value of c: ");
        c = input.nextDouble();

        result1 = a + b * c;
        result2 = a * b + c;
        result3 = c + a / b;
        result4 = a % b + c;

        System.out.println(
                "The results of Double Operations are " +
                        result1 + ", " + result2 + ", " + result3 + ", and " + result4
        );
    }
}
