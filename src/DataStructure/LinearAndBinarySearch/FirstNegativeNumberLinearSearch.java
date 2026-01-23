package datastructure.linearandbinarysearch;

public class FirstNegativeNumberLinearSearch {
    public static void main(String[] args) {
        int[] arr = {5, 8, -3, 9};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                System.out.println("First Negative Index: " + i);
                return;
            }
        }
        System.out.println("-1");
    }
}
