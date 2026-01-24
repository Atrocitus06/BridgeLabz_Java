package DataStructure.AlgorithmComparison;
import java.util.Random;

/**
 * ArraySearch: Linear search O(n) worst/average case
 * Sequential scan from index 0 → n-1
 * Simple, no extra memory, cache-friendly for small arrays
 */
public class ArraySearch {

    /**
     * search: Linear scan implementation
     * @param arr sorted/unsorted array
     * @param target value to find
     * @return index or -1
     */
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // Found at index i
            }
        }
        return -1;  // Not found
    }

    public static void main(String[] args) {
        Random rand = new Random(42);
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000000);
        }

        int target = arr[arr.length / 2];  // Middle element (avg case)
        long start = System.nanoTime();
        int result = search(arr, target);
        long timeNs = System.nanoTime() - start;

        System.out.printf("ArraySearch n=%d: %d ns (found @ %d)%n",
                arr.length, timeNs, result);
    }
}

