package datastructure.linearandbinarysearch;

public class ReverseStringUsingStringBuilder {
    public static void main(String[] args) {
        String input = "hello";

        StringBuilder sb = new StringBuilder(input);
        sb.reverse();

        System.out.println("Reversed String: " + sb.toString());
    }
}
