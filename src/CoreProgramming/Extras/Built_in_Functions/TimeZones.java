package core_programming.Extras.Built_in_Functions;
/*
1. Problem 1: Time Zones and ZonedDateTime Write a program that displays the current
time in different time zones:
➢ GMT (Greenwich Mean Time)
➢ IST (Indian Standard Time)
➢ PST (Pacific Standard Time)
Hint: Use ZonedDateTime and ZoneId to work with different time zones.
 */
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Scanner;

public class TimeZones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of places: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter time zone (example: Asia/Kolkata): ");
            String zone = sc.nextLine();

            ZonedDateTime time = ZonedDateTime.now(ZoneId.of(zone));
            System.out.println("Current time in " + zone + " : " + time);
        }
    }
}
