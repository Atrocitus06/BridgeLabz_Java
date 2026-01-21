package DataStructure.StacksAndQueues;
import java.util.*;

/**
 CircularTour: Finds starting petrol pump index for complete circular tour (Updated: Dynamic array input)
 Supports fully dynamic input: Enter n first, then petrol[], distance[] arrays of size n.
 All other features preserved: Menu-driven, detailed comments, validation, preset option.

 Input Flow:
 1. Enter n
 2. Enter n petrol values (space/integer separated)
 3. Enter n distance values

 Enhanced array input handling:
 - Reads complete line for arrays using nextLine() after n
 - Parses space-separated integers with error handling
 - Validates array length matches n

 Example Session:
 Enter n: 5
 Enter petrol (space separated): 1 5 3 3 5
 Enter distance (space separated): 3 4 4 3 5
 */
public class CircularTour {

    /**
     findStartingPoint: Core algorithm (unchanged)
     @param petrol array of petrol available at each pump
     @param distance array of distance/cost to next pump
     @return starting index or -1 if impossible
     */
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalSurplus = 0;
        int currSurplus = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int surplus = petrol[i] - distance[i];
            totalSurplus += surplus;
            currSurplus += surplus;

            if (currSurplus < 0) {
                start = i + 1;
                currSurplus = 0;
            }
        }

        return (totalSurplus >= 0) ? start : -1;
    }

    /**
     readIntArray: Helper to read space-separated integers from line
     @param sc Scanner
     @param expectedSize expected array length
     @return parsed int array or null if invalid
     */
    private static int[] readIntArray(Scanner sc, int expectedSize, String prompt) {
        System.out.print(prompt);
        String line = sc.nextLine().trim();
        String[] parts = line.split("\\s+");

        if (parts.length != expectedSize) {
            System.out.printf("Expected %d values, got %d!%n", expectedSize, parts.length);
            return null;
        }

        try {
            int[] arr = new int[expectedSize];
            for (int i = 0; i < expectedSize; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            return arr;
        } catch (NumberFormatException e) {
            System.out.println("Invalid integers!");
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Circular Tour Problem ===");
            System.out.println("1. Custom input (dynamic arrays)");
            System.out.println("2. Preset example");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter n (number of pumps): ");
                    int n;
                    try {
                        n = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid n!");
                        break;
                    }

                    if (n <= 0) {
                        System.out.println("n must be positive!");
                        break;
                    }

                    // Dynamic array input
                    int[] petrol = readIntArray(sc, n, "Enter petrol amounts (space separated): ");
                    if (petrol == null) break;

                    int[] distance = readIntArray(sc, n, "Enter distances (space separated): ");
                    if (distance == null) break;

                    // Display input
                    System.out.println("Petrol: " + Arrays.toString(petrol));
                    System.out.println("Distance: " + Arrays.toString(distance));

                    int start = findStartingPoint(petrol, distance);
                    if (start == -1) {
                        System.out.println("No starting point possible.");
                    } else {
                        System.out.printf("Starting petrol pump index: %d%n", start);
                    }
                    break;

                case 2:
                    int[] presetPetrol = {1, 5, 3, 3, 5};
                    int[] presetDistance = {3, 4, 4, 3, 5};
                    System.out.println("Preset Petrol: " + Arrays.toString(presetPetrol));
                    System.out.println("Preset Distance: " + Arrays.toString(presetDistance));
                    int presetStart = findStartingPoint(presetPetrol, presetDistance);
                    System.out.printf("Starting index: %d%n", presetStart);
                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}

