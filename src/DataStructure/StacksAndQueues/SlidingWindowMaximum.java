package DataStructure.StacksAndQueues;
import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        Deque<Integer> deque = new ArrayDeque<>(); // stores indices
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // remove indices that are out of current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // remove indices whose corresponding values are smaller than current
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // add current index
            deque.offerLast(i);

            // if window has k elements, add max to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements of array: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter the window length: ");
        int k = sc.nextInt();
        System.out.println("Input array: " + Arrays.toString(nums));
        System.out.println("Window size k: " + k);

        int[] result = maxSlidingWindow(nums, k);
        System.out.println("Maximums in sliding windows: " + Arrays.toString(result));
    }
}
