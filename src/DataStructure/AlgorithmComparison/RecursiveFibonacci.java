package DataStructure.AlgorithmComparison;
/**
 * RecursiveFibonacci: Pure recursive Fibonacci implementation
 * f(n) = f(n-1) + f(n-2), base: f(0)=0, f(1)=1
 * Time: O(2^n) exponential - massive redundant computation
 * Stack depth: n → StackOverflowError @ n>40-50
 * Matches table: 1ms(n=10), 156ms(n=30), infeasible(n=40+) [file:39]
 */
public class RecursiveFibonacci {

    /**
     * fibonacci: Classic recursive solution (textbook example)
     * Each call branches into 2 subproblems → binary tree of height n
     * fib(5) makes 15 total calls despite only needing f(0..5)
     */
    public static long fibonacci(int n) {
        // Base cases (stop recursion)
        if (n <= 1) {
            return n;
        }

        // Recursive case: exponential branching
        // T(n) = T(n-1) + T(n-2) + O(1) ≈ φ^n / √5 where φ=(1+√5)/2
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void main(String[] args) {
        int n = 10;  // Small n only!
        long result = fibonacci(n);
        System.out.printf("Recursive fib(%d) = %d%n", n, result);
    }
}