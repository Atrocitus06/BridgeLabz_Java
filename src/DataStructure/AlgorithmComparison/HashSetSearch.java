package DataStructure.AlgorithmComparison;
import java.util.HashSet;
import java.util.Random;

/**
 * HashSetSearch: Hash table lookup O(1) average case
 * HashSet uses hashCode() + equals() → constant time lookups
 * Extra memory O(n), hash collisions degrade to O(n) worst case
 */
public class HashSetSearch {

    /**
     * search: O(1) average time HashSet lookup
     */
    public static boolean search(HashSet<Integer> set, int target) {
        return set.contains(target);  // Single hash lookup
    }

    public static void main(String[] args) {
        Random rand = new Random(42);
        int n = 100000;
        HashSet<Integer> set = new HashSet<>();

        // Populate set
        for (int i = 0; i < n; i++) {
            set.add(rand.nextInt(1000000));
        }

        int target = set.iterator().next();  // Existing element
        long start = System.nanoTime();
        boolean found = search(set, target);
        long timeNs = System.nanoTime() - start;

        System.out.printf("HashSetSearch n=%d: %d ns (%s)%n", n, timeNs, found);
    }
}
