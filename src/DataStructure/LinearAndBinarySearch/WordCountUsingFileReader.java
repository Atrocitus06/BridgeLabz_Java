package datastructure.linearandbinarysearch;

import java.io.BufferedReader;
import java.io.FileReader;

public class WordCountUsingFileReader {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String line;
        int count = 0;
        String target = "java";

        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equalsIgnoreCase(target)) {
                    count++;
                }
            }
        }
        br.close();
        System.out.println("Word Count: " + count);
    }
}
