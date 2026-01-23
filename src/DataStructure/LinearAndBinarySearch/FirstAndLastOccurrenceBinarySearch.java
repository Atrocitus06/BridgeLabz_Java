package datastructure.linearandbinarysearch;

public class FirstAndLastOccurrenceBinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 6};
        int target = 4;

        int first = -1, last = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("First: " + first + ", Last: " + last);
    }
}
