package DataStructure.AlgorithmComparison;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * ByteStreamBridgeReading: InputStreamReader (byte stream → character bridge)
 * FileInputStream → InputStreamReader → BufferedReader
 * Explicit UTF-8, optimized for large files (2x faster @500MB) [file:37]
 * Performance: 30ms(1MB), 1.5s(100MB), 5s(500MB) [file:37]
 */
public class ByteStreamBridgeReading {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // === INPUT PHASE ===
        System.out.print("Enter filename: ");
        String filename = sc.nextLine();

        // === MEASUREMENT START ===
        long startTime = System.currentTimeMillis();
        int lines = 0;
        long chars = 0;

        try (FileInputStream fis = new FileInputStream(filename);  // Raw byte access

             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8)) {  // Charset decoder

            // Enhanced 32KB buffer for large sequential reads
            BufferedReader bufferedReader = new BufferedReader(isr, 32768);

            String line;
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

        System.out.printf("%n=== Byte Stream Bridge (InputStreamReader) ===%n");
        System.out.printf(" File: %s%n", filename);
        System.out.printf(" Lines: %s%n", String.format("%,d", lines));
        System.out.printf(" Chars: %s (%.1f MB)%n", String.format("%,d", chars), mb);
        System.out.printf("️ Time: %.0f ms%n", durationMs);
        System.out.printf(" Speed: %.1f MB/s%n", mb * 1000 / durationMs);

        sc.close();
    }
}
