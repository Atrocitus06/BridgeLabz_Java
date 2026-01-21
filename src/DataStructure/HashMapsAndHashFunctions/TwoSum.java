package DataStructure.HashMapsAndHashFunctions;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No solution found");
        }
    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            // check if required value already exists
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // store current value and its index
            map.put(nums[i], i);
        }

        return new int[] {}; // no solution
    }
}