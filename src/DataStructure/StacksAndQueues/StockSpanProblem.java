package DataStructure.StacksAndQueues;
import java.util.Scanner;
import java.util.Stack;

/**
 StockSpanProblem: Solves stock span problem using monotonic decreasing stack
 For each day i, span[i] = count of consecutive previous days (incl. i) where price <= prices[i]
 Stack maintains indices of prices in strictly decreasing order (price[stack.top()] > price[next])
 Time: O(n) amortized - each index pushed/popped exactly once, Space: O(n) stack
 Menu-driven interface for custom price arrays with results table display
 */
public class StockSpanProblem {

    // Monotonic stack: stores indices i where prices decreasing (larger prices closer to top)
    private static Stack<Integer> monotonicStack = new Stack<>();
    private static Scanner sc = new Scanner(System.in);

    /**
     Program entry point: Interactive menu for stock span operations
     Workflow: 1.Read prices → 2.Compute spans → 3.Display results table → repeat or exit
     State maintained: prices array + spans array (null until computed)
     */
    public static void main(String[] args) {
        System.out.println("Stock Span Problem Menu");
        System.out.println("1. Enter stock prices");
        System.out.println("2. Compute spans");
        System.out.println("3. Display prices and spans");
        System.out.println("4. Exit");

        int[] prices = null;  // Input stock prices array
        int[] spans = null;   // Computed span values

        while (true) {
            System.out.print("\nEnter choice (1-4): ");
            String input = sc.nextLine().trim();

            // Exit condition
            if (input.equals("4")) {
                System.out.println("Exiting...");
                break;
            }

            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        prices = readPrices();
                        System.out.println("Prices entered successfully");
                        break;

                    case 2:
                        if (prices == null) {
                            System.out.println("Enter prices first (option 1)");
                        } else {
                            spans = calculateSpans(prices);
                            System.out.println("Spans computed successfully");
                        }
                        break;

                    case 3:
                        if (prices == null || spans == null) {
                            System.out.println("Enter prices and compute spans first");
                        } else {
                            displayResults(prices, spans);
                        }
                        break;

                    default:
                        System.out.println("Invalid choice. Enter 1-4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter 1-4.");
            }
        }
        sc.close();
    }

    /**
     Interactive input: Read array size n, then n positive integer prices
     Uses nextLine() for robust multi-line input handling
     Returns newly allocated int[] of size n
     */
    private static int[] readPrices() {
        System.out.print("Enter number of days: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        int[] prices = new int[n];
        System.out.println("Enter " + n + " stock prices:");
        for (int i = 0; i < n; i++) {
            // Parse each price, assumes valid positive integers
            prices[i] = Integer.parseInt(sc.nextLine().trim());
        }
        return prices;
    }

    /**
     Core algorithm: Computes spans[i] for each day using stack
     Key invariant: Stack contains indices in increasing order, prices strictly decreasing

     For each i:
     1. While stack not empty AND prices[stack.top()] <= prices[i]: pop (those days included in span)
     2. span[i] = i - stack.top() (distance to previous strictly greater) OR i+1 if empty
     3. Push i onto stack

     Returns spans array same size as prices
     */
    public static int[] calculateSpans(int[] prices) {
        int n = prices.length;
        int[] spans = new int[n];

        // Reset stack for fresh computation
        monotonicStack.clear();

        for (int i = 0; i < n; i++) {
            // Remove indices of smaller/equal prices (they extend current span)
            while (!monotonicStack.isEmpty() &&
                    prices[monotonicStack.peek()] <= prices[i]) {
                monotonicStack.pop();
            }

            // Calculate span: days from previous greater price (or start)
            if (monotonicStack.isEmpty()) {
                spans[i] = i + 1;  // Full prefix up to i
            } else {
                spans[i] = i - monotonicStack.peek();  // Distance to previous greater
            }

            // Maintain invariant: push current index
            monotonicStack.push(i);
        }
        return spans;
    }

    /**
     Prints formatted table: Day | Price | Span
     Uses printf for aligned columns, shows top-to-bottom day order
     */
    private static void displayResults(int[] prices, int[] spans) {
        System.out.println("\nDay | Price | Span");
        System.out.println("----|-------|-----");
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("%2d  | %5d | %3d%n", i, prices[i], spans[i]);
        }
    }
}
