package DataStructure.AlgorithmComparison;
import java.util.Random;
import java.util.TreeSet;

/**
 * TreeSetSearch: Balanced BST O(log n) guaranteed
 * Red-black tree maintains sorted order
 * Slower than HashSet but ordered iteration + range queries
 */
public class TreeSetSearch {

    /**
     * search: Binary search tree lookup O(log n)
     * Height-balanced → consistent performance
     */
    public static boolean search(TreeSet<Integer> set, int target) {
        return set.contains(target);  // log(n) tree traversal
    }

    public static void main(String[] args) {
        Random rand = new Random(42);
        int n = 100000;
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(rand.nextInt(1000000));
        }

        int target = set.first();  // Existing element
        long start = System.nanoTime();
        boolean found = search(set, target);
        long timeNs = System.nanoTime() - start;

        System.out.printf("TreeSetSearch n=%d: %d ns (%s)%n", n, timeNs, found);
    }
}
