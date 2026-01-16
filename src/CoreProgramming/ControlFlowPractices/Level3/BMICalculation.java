package core_programming.ControlFlowPractices.Level3;/*
Create a program to find the BMI of a person
Hint =>
Take user input in double for the weight (in kg) of the person and height (in cm) for the person and store it in the corresponding variable.
Use the formula BMI = weight / (height * height). Note unit is kg/m^2. For this convert cm to meter
Use the table to determine the weight status of the person

 */

import java.util.Scanner;

public class BMICalculation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double weight;      // in kg
        double heightCm;    // in cm
        double heightMeter; // in meters
        double bmi;

        System.out.print("Enter weight in kg: ");
        weight = input.nextDouble();

        System.out.print("Enter height in cm: ");
        heightCm = input.nextDouble();

        heightMeter = heightCm / 100;   // convert cm to meter
        bmi = weight / (heightMeter * heightMeter);

        System.out.println("BMI = " + bmi);

        if (bmi <= 18.4) {
            System.out.println("Status: Underweight");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Status: Normal");
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            System.out.println("Status: Overweight");
        } else {
            System.out.println("Status: Obese");
        }
    }
}
