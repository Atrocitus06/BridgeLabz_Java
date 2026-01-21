package DataStructure.HashMapsAndHashFunctions;
import java.util.*;

/**
 * PairWithGivenSumMain: Complete solution - check if pair sums to target using HashSet
 * One-pass algorithm: For each arr[i], check if (target - arr[i]) exists in seen
 * Add arr[i] after check to handle duplicates correctly
 *
 * Time: O(n), Space: O(n)
 * Returns true/false + shows the actual pair if found
 *
 * Example: arr=[2,4,7,11], target=9 → 2+7=9 ✓
 */
public class PairWithGivenSum{

    /**
     * hasPairWithSum: Core algorithm - returns pair indices or null
     * @param arr input array
     * @param target target sum
     * @return [i,j] where arr[i]+arr[j]==target, i < j or null
     */
    public static int[] hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();  // numbers encountered so far

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // Check if complement exists in previously seen numbers
            if (seen.contains(complement)) {
                // Find the actual index of complement (for output)
                for (int j = 0; j < i; j++) {
                    if (arr[j] == complement) {
                        return new int[]{j, i};
                    }
                }
            }

            // Add current number to seen
            seen.add(arr[i]);
        }

        return null;  // no pair found
    }

    /**
     * printResult: Display result clearly
     */
    private static void printResult(int[] arr, int target, int[] pair) {
        System.out.println("\n=== Result ===");
        if (pair == null) {
            System.out.println("No pair sums to " + target);
            return;
        }

        int i = pair[0], j = pair[1];
        System.out.printf("✓ Found pair at indices [%d,%d]: %d + %d = %d%n",
                i, j, arr[i], arr[j], target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // === INPUT ===
        System.out.print("Enter array size n: ");
        int n = sc.nextInt();

        if (n < 2) {
            System.out.println("Need at least 2 elements!");
            sc.close();
            return;
        }

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        // === COMPUTE ===
        int[] pair = hasPairWithSum(arr, target);

        // === OUTPUT ===
        System.out.println("\nArray: " + Arrays.toString(arr));
        printResult(arr, target, pair);

        sc.close();
    }
}

