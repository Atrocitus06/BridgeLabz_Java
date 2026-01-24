package DataStructure.AlgorithmComparison;
import java.io.*;
import java.util.Scanner;

/**
 * CharacterStreamReading: FileReader implementation (pure character stream)
 * FileReader → BufferedReader pipeline for text processing
 * Platform charset, simpler API, suitable for small files (<10MB)
 * Performance profile: 50ms(1MB), 3s(100MB), 10s(500MB) [file:37]
 */
public class CharacterStreamReading {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // === INPUT PHASE ===
        System.out.print("Enter filename: ");
        String filename = sc.nextLine();

        // === MEASUREMENT START ===
        long startTime = System.currentTimeMillis();
        int lines = 0;
        long chars = 0;

        try (FileReader fr = new FileReader(filename)) {  // Character stream entry point

            BufferedReader bufferedReader = new BufferedReader(fr);  // Line buffering

            String line;
            // Efficient line iteration (internal buffer reduces syscalls)
            while ((line = bufferedReader.readLine()) != null) {
                lines++;
                chars += line.length();
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("IO error: " + e.getMessage());
        }

        // === RESULTS ===
        long durationMs = System.currentTimeMillis() - startTime;
        double mb = chars / (1024.0 * 1024);

        System.out.printf("%n=== Character Stream Reading (FileReader) ===%n");
        System.out.printf(" File: %s%n", filename);
        System.out.printf(" Lines: %s%n", String.format("%,d", lines));
        System.out.printf(" Chars: %s (%.1f MB)%n", String.format("%,d", chars), mb);
        System.out.printf(" Time: %.0f ms%n", durationMs);
        System.out.printf(" Speed: %.1f MB/s%n", mb * 1000 / durationMs);

        sc.close();
    }
}
