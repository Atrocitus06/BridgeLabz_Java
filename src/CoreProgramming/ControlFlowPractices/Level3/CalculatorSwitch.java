package core_programming.ControlFlowPractices.Level3;/*
10. Write a program to create a calculator using switch...case.
Hint =>
Create two double variables named first and second and a String variable named op.
Get input values for all variables.
The input for the operator can only be one of the four values: "+", "-", "*" or "/".
Run a for loop from i = 1 to i < number.
Based on the input value of the op, perform specific operations using the switch...case statement and print the result.
If op is +, perform addition between first and second; if it is -, perform subtraction and so on.
If op is neither of those 4 values, print Invalid Operator.
*/

import java.util.Scanner;

public class CalculatorSwitch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double first;
        double second;
        String op;
        double result;

        System.out.print("Enter first number: ");
        first = input.nextDouble();

        System.out.print("Enter second number: ");
        second = input.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        op = input.next();

        switch (op) {
            case "+":
                result = first + second;
                System.out.println("Result = " + result);
                break;

            case "-":
                result = first - second;
                System.out.println("Result = " + result);
                break;

            case "*":
                result = first * second;
                System.out.println("Result = " + result);
                break;

            case "/":
                if (second != 0) {
                    result = first / second;
                    System.out.println("Result = " + result);
                } else {
                    System.out.println("Division by zero is not allowed");
                }
                break;

            default:
                System.out.println("Invalid Operator");
        }
    }
}
