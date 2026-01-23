package datastructure.linearandbinarysearch;

public class ConcatenateStringsUsingStringBuffer {
    public static void main(String[] args) {
        String[] words = {"Hello", " ", "Java", " ", "World"};
        StringBuffer sb = new StringBuffer();

        for (String word : words) {
            sb.append(word);
        }

        System.out.println(sb.toString());
    }
}
