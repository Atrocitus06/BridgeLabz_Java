package core_programming.ProgrammingElements.Level1;/*Create a program to convert the distance of 10.8 kilometers to miles.
Hint: 1 km = 1.6 miles
I/P => NONE
O/P => The distance  ___ km in miles is ___
*/

public class KmToMiles {
    public static void main(String[] args) {

        double kilometers = 10.8;
        double miles;

        miles = kilometers * 1.6;

        System.out.println("The distance " + kilometers + " km in miles is " + miles);
    }
}
