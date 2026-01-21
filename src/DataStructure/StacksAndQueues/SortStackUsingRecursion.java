package DataStructure.StacksAndQueues;
import java.util.Scanner;
import java.util.Stack;

/**
 SortStackUsingRecursion: Complete implementation with menu-driven custom inputs
 Single class handles: recursive sorting + interactive CLI (push/sort/display/pop/empty/exit)
 Recursive algorithm: sortStack() + sortedInsert(), O(n^2) time, O(n) recursion space
 Ascending order achieved: smallest at bottom (last popped), largest at top (first popped)
 */
public class SortStackUsingRecursion {

    private static Stack<Integer> stack = new Stack<>();
    private static Scanner sc = new Scanner(System.in);

    /**
     Main entry: Displays menu and handles user choices 1-6
     Delegates to helper methods for clean separation
     */
    public static void main(String[] args) {
        System.out.println("Stack Sorter Menu");
        System.out.println("1. Push element");
        System.out.println("2. Sort stack (ascending)");
        System.out.println("3. Display stack");
        System.out.println("4. Pop element");
        System.out.println("5. Check if empty");
        System.out.println("6. Exit");

        while (true) {
            System.out.print("\nEnter choice (1-6): ");
            String input = sc.nextLine().trim();

            if (input.equals("6")) {
                System.out.println("Exiting...");
                break;
            }

            try {
                int choice = Integer.parseInt(input);
                handleChoice(choice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter 1-6.");
            }
        }
        sc.close();
    }

    /**
     Routes user choice to appropriate stack operation
     Input validation + method delegation
     */
    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Enter number to push: ");
                int num = Integer.parseInt(sc.nextLine().trim());
                stack.push(num);
                System.out.println("Pushed " + num);
                break;

            case 2:
                if (stack.isEmpty()) {
                    System.out.println("Stack empty - nothing to sort");
                } else {
                    sortStack(stack);
                    System.out.println("Stack sorted ascending (smallest at bottom)");
                }
                break;

            case 3:
                displayStack();
                break;

            case 4:
                if (stack.isEmpty()) {
                    System.out.println("Stack empty");
                } else {
                    System.out.println("Popped: " + stack.pop());
                }
                break;

            case 5:
                System.out.println("Stack empty: " + stack.isEmpty());
                break;

            default:
                System.out.println("Invalid choice. Enter 1-6.");
        }
    }

    /**
     Recursively sorts stack in ascending order
     Algorithm: Pop top → recursively sort remainder → insert top back in sorted position
     Base case: empty stack returns immediately
     */
    private static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();
        sortStack(st);
        sortedInsert(st, top);
    }

    /**
     Inserts element x into already-sorted stack maintaining ascending order
     Recursive helper: If top <= x, push directly. Else recurse and restore displaced elements
     */
    private static void sortedInsert(Stack<Integer> st, int x) {
        if (st.isEmpty() || st.peek() <= x) {
            st.push(x);
            return;
        }

        int top = st.pop();
        sortedInsert(st, x);
        st.push(top);
    }

    /**
     Displays stack contents from top to bottom
     Uses get(i) for readable top-first output (stacks print bottom-first by default)
     */
    private static void displayStack() {
        if (stack.isEmpty()) {
            System.out.println("Stack empty");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }
}
