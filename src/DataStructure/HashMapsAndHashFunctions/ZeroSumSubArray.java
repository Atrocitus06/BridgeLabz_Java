package DataStructure.HashMapsAndHashFunctions;
import java.util.*;

/**
 * ZeroSumSubarraysMain: Complete solution in single class with continuous flow
 * Finds ALL subarrays summing to 0 using prefix sums + HashMap
 * User input → compute → verify & print results
 *
 * Algorithm (O(n) time, O(n) space):
 * 1. prefix[i] = sum(arr[0..i-1])
 * 2. HashMap: prefixSum → earliest index
 * 3. When prefix repeats: subarray[start..i] sums to 0 where start = map.get(prefix)+1
 * 4. prefix=0 at -1 handles subarrays from index 0
 *
 * Example: arr = [1, -1, 0, 2, -2]
 * prefix: [0, 1, 0, 0, 2, 0]
 * Repeats: prefix[1]=prefix[2] → [0,1], prefix[2]=prefix[4] → [2,2], etc.
 */
public class ZeroSumSubArray{

    /**
     * findAllZeroSumSubarrays: Core algorithm
     * @param arr input array
     * @return List<[left,right]> indices of all zero-sum subarrays
     */
    public static List<int[]> findAllZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);  // base case: empty prefix

        int prefix = 0;

        for (int i = 0; i < arr.length; i++) {
            prefix += arr[i];

            if (prefixMap.containsKey(prefix)) {
                // zero sum from map.get(prefix)+1 to i
                result.add(new int[]{prefixMap.get(prefix) + 1, i});
            }

            // record first occurrence
            if (!prefixMap.containsKey(prefix)) {
                prefixMap.put(prefix, i);
            }
        }

        return result;
    }

    /**
     * verifyAndPrint: Print subarrays with verified sums
     */
    private static void verifyAndPrint(int[] arr, List<int[]> subarrays) {
        System.out.println("\n=== All Zero Sum Subarrays ===");
        if (subarrays.isEmpty()) {
            System.out.println("No zero-sum subarrays found.");
            return;
        }

        System.out.printf("%-8s %-8s %-15s %s%n", "Start", "End", "Subarray", "Sum");
        System.out.println("----------------------------------------");

        for (int[] sub : subarrays) {
            int left = sub[0], right = sub[1];
            int sum = 0;
            for (int j = left; j <= right; j++) {
                sum += arr[j];
            }

            int[] slice = Arrays.copyOfRange(arr, left, right + 1);
            System.out.printf("%-8d %-8d %-15s %d%n",
                    left, right, Arrays.toString(slice), sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // === INPUT ===
        System.out.print("Enter array size n: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid n!");
            sc.close();
            return;
        }

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // === COMPUTE ===
        List<int[]> zeroSums = findAllZeroSumSubarrays(arr);

        // === OUTPUT ===
        System.out.println("\nInput: " + Arrays.toString(arr));
        System.out.printf("Total zero-sum subarrays found: %d%n", zeroSums.size());
        verifyAndPrint(arr, zeroSums);

        sc.close();
    }
}
