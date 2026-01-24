package DataStructure.AlgorithmComparison;
/**
 * IterativeFibonacci: Linear time O(n), constant space O(1)
 * Bottom-up dynamic programming
 * No stack overhead, scales to n=90+ [file:39]
 */
public class IterativeFibonacci {

    /**
     * fibonacci: Space-optimized iterative solution
     * Sliding window of 2 variables: prev2, prev1 → current
     */
    public static long fibonacci(int n) {
        if (n <= 1) return n;

        long a = 0, b = 1;  // f(0), f(1)
        for (int i = 2; i <= n; i++) {
            long next = a + b;  // O(1) per iteration
            a = b;
            b = next;
        }
        return b;
    }

    // Test main for standalone testing
    public static void main(String[] args) {
        int n = 40;
        long result = fibonacci(n);
        System.out.printf("Iterative fib(%d) = %d%n", n, result);
    }
}
