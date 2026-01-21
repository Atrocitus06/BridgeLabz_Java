package DataStructure.StacksAndQueues;
import java.util.Scanner;
import java.util.Stack;

/**
 * ImplementQueueUsingStack: Queue using two stacks (LeetCode 232 solution)
 * Uses inputStack for O(1) push, outputStack for amortized O(1) pop/peek
 * Transfer reverses order to maintain FIFO behavior
 */
public class ImplementQueueUsingStack {

    // inputStack: stores new elements (push directly O(1))
    private Stack<Integer> inputStack;

    // outputStack: stores elements in reverse order for pop/peek (front first)
    private Stack<Integer> outputStack;

    /**
     * Constructor: Initialize empty stacks
     * Both stacks start empty, ready for push operations
     */
    public ImplementQueueUsingStack() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    /**
     * push(x): Add to back → inputStack.push()
     * Always O(1), no transfer needed
     */
    public void push(int x) {
        inputStack.push(x);  // New elements go here
    }

    /**
     * pop(): Remove front → outputStack.pop()
     * If output empty → transfer() reverses inputStack
     * Amortized O(1) across operations
     */
    public int pop() {
        // Lazy transfer: only when outputStack empty
        if (outputStack.isEmpty()) {
            transfer();  // O(n) but rare
        }
        return outputStack.pop();  // O(1) front removal
    }

    /**
     * peek(): View front → outputStack.peek()
     * Same transfer logic as pop()
     */
    public int peek() {
        if (outputStack.isEmpty()) {
            transfer();
        }
        return outputStack.peek();  // Non-destructive peek
    }

    /**
     * empty(): True if both stacks empty
     * Complete queue state check
     */
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    /**
     * transfer(): Move inputStack → outputStack (reverse for FIFO)
     * Called only when outputStack empty → avoids repeated work
     * Each element transferred exactly once per lifecycle
     */
    private void transfer() {
        // Pop all from input, push to output → reverses order
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
    }

    /**
     * main(): Interactive CLI tester with Scanner input
     * Commands: push/pop/peek/empty/exit
     * Demonstrates all queue operations in real-time
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ImplementQueueUsingStack queue = new ImplementQueueUsingStack();

        System.out.println("=== Queue using Stacks Demo ===");
        System.out.println("Commands: push/pop/peek/empty/exit");

        // Interactive loop until exit
        while (true) {
            System.out.print("\nEnter command: ");
            String cmd = sc.nextLine().trim().toLowerCase();

            // Command dispatcher
            switch (cmd) {
                case "push":
                    // User inputs value to enqueue
                    System.out.print("Enter value to push: ");
                    int val = Integer.parseInt(sc.nextLine().trim());
                    queue.push(val);
                    System.out.println("Pushed " + val + " to back");
                    break;

                case "pop":
                    // Dequeue front element
                    if (!queue.empty()) {
                        int front = queue.pop();
                        System.out.println("Popped front: " + front);
                    } else {
                        System.out.println("Queue is empty!");
                    }
                    break;

                case "peek":
                    // View front without removing
                    if (!queue.empty()) {
                        System.out.println("Front element: " + queue.peek());
                    } else {
                        System.out.println("✗ Queue is empty!");
                    }
                    break;

                case "empty":
                    // Check queue state
                    System.out.println("Queue empty: " + queue.empty());
                    break;

                case "exit":
                    System.out.println("Demo ended. Happy coding!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid command! Try: push/pop/peek/empty/exit");
            }
        }
    }
}
