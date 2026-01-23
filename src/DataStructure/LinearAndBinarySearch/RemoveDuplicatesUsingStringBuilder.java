package datastructure.linearandbinarysearch;

import java.util.HashSet;

public class RemoveDuplicatesUsingStringBuilder {
    public static void main(String[] args) {
        String input = "programming";
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for (char ch : input.toCharArray()) {
            if (!set.contains(ch)) {
                sb.append(ch);
                set.add(ch);
            }
        }
        System.out.println("Without Duplicates: " + sb.toString());
    }
}
