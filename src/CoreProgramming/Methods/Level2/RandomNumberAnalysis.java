package core_programming.Methods.Level2;
/*
Write a program that generates five 4 digit random values and then finds their
average value, and their minimum and maximum value. Use Math.random(), Math.min(),
and Math.max().
Hint =>
Write a method that generates array of 4 digit random numbers given the size as a
parameter as shown in the method signature
public int[] generate4DigitRandomArray(int size)
Write a method to find average, min and max value of an array
public double[] findAverageMinMax(int[] numbers)
*/

import java.util.Scanner;

public class RandomNumberAnalysis {

    public static int[] generate4DigitRandomArray(int size) {

        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 9000) + 1000; // 1000–9999
        }

        return numbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {

        int min = numbers[0];
        int max = numbers[0];
        int sum = 0;

        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        double average = (double) sum / numbers.length;

        return new double[]{average, min, max};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many random numbers you want: ");
        int size = sc.nextInt();

        int[] numbers = generate4DigitRandomArray(size);

        System.out.print("Generated 4-digit numbers: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println();

        double[] result = findAverageMinMax(numbers);

        System.out.println("Average value: " + result[0]);
        System.out.println("Minimum value: " + (int) result[1]);
        System.out.println("Maximum value: " + (int) result[2]);

        sc.close();
    }
}
