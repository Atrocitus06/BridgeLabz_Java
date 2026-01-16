package core_programming.Extras.Built_in_Functions;
/*
3. Problem 3: Date Formatting Write a program that:
➢ Displays the current date in three different formats:
■ dd/MM/yyyy
■ yyyy-MM-dd
■ EEE, MMM dd, yyyy

Hint: Use DateTimeFormatter with custom patterns for date formatting.
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        System.out.println("Format 1 (dd/MM/yyyy): " + today.format(format1));
        System.out.println("Format 2 (yyyy-MM-dd): " + today.format(format2));
        System.out.println("Format 3 (EEE, MMM dd, yyyy): " + today.format(format3));
    }
}
