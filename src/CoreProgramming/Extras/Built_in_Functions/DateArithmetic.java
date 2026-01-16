package core_programming.Extras.Built_in_Functions;
/*
2. Problem 2: Date Arithmetic Create a program that:
➢ Takes a date input and adds 7 days, 1 month, and 2 years to it.
➢ Then subtracts 3 weeks from the result.
Hint: Use LocalDate.plusDays(), plusMonths(), plusYears(), and
minusWeeks() methods.
 */


import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date (YYYY-MM-DD): ");
        String inputDate = sc.nextLine();

        LocalDate date = LocalDate.parse(inputDate);

        LocalDate result = date.plusDays(7)
                .plusMonths(1)
                .plusYears(2);


        result = result.minusWeeks(3);

        System.out.println("Final Date after calculations: " + result);
    }
}
