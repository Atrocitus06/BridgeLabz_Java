package core_programming.String.Level3;
/*
An organization took up the exercise to find the Body Mass Index (BMI) of all the persons in a team of 10 members. For this create a program to find the BMI and display the height, weight, BMI, and status of each individual
Hint =>
Take user input for the person's weight (kg) and height (cm) and store it in the corresponding 2D array of 10 rows. The First Column stores the weight and the second column stores the height in cm
Create a Method to find the BMI and status of every person given the person's height and weight and return the 2D String array. Use the formula BMI = weight / (height * height). Note unit is kg/m^2. For this convert cm to meter
Create a Method that takes the 2D array of height and weight as parameters. Calls the user-defined method to compute the BMI and the BMI Status and stores in a 2D String array of height, weight, BMI, and status.
Create a method to display the 2D string array in a tabular format of Person's Height, Weight, BMI, and the Status
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result.
*/

import java.util.Scanner;

public class BMIProgram {

    public static String[] calculateBMI(double weight, double heightCm) {

        double heightMeter = heightCm / 100;
        double bmi = weight / (heightMeter * heightMeter);

        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        String[] result = new String[2];
        result[0] = String.format("%.2f", bmi);
        result[1] = status;

        return result;
    }

    public static String[][] prepareResult(double[][] data) {

        String[][] result = new String[10][4];

        for (int i = 0; i < 10; i++) {
            String[] bmiData = calculateBMI(data[i][0], data[i][1]);

            result[i][0] = String.valueOf(data[i][1]); // Height
            result[i][1] = String.valueOf(data[i][0]); // Weight
            result[i][2] = bmiData[0];                  // BMI
            result[i][3] = bmiData[1];                  // Status
        }

        return result;
    }

    public static void displayResult(String[][] result) {

        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\tStatus");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            System.out.println(
                    result[i][0] + "\t\t" +
                            result[i][1] + "\t\t" +
                            result[i][2] + "\t" +
                            result[i][3]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][2]; // [weight, height]

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1));

            System.out.print("Enter Weight (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter Height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        String[][] result = prepareResult(data);
        displayResult(result);

        sc.close();
    }
}
