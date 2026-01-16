package core_programming.ProgrammingElements.Level1;/*
9. Write a new program similar to the program # 6 but take user input for Student Fee and University Discount
Hint =>
Create a variable named fee and take user input for fee.
Create another variable discountPercent and take user input.
Compute the discount and assign it to the discount variable.
Compute and print the fee you have to pay by subtracting the discount from the fee.
I/P => fee, discountPrecent
O/P => The discount amount is INR ___ and final discounted fee is INR ___
*/

import java.util.Scanner;

public class UniversityFeeDiscountInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double fee;
        double discountPercent;
        double discount;
        double finalFee;

        System.out.print("Enter Student Fee: ");
        fee = input.nextDouble();

        System.out.print("Enter Discount Percentage: ");
        discountPercent = input.nextDouble();

        discount = (fee * discountPercent) / 100;
        finalFee = fee - discount;

        System.out.println(
                "The discount amount is INR " + discount +
                        " and final discounted fee is INR " + finalFee
        );
    }
}
