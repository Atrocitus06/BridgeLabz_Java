package core_programming.ProgrammingElements.Level1;/*Write a program to find the age of Harry if the birth year is 2000. Assume the Current Year is 2024
I/P => NONE
O/P => Harry's age in 2024 is ___
*/

public class Age {
    public static void main(String[] args) {

        int birthYear = 2000;
        int currentYear = 2024;
        int age;

        age = currentYear - birthYear;

        System.out.println("Harry's age in 2024 is " + age);
    }
}
