package datastructure.linearandbinarysearch;

public class SearchWordInSentencesLinearSearch {
    public static void main(String[] args) {
        String[] sentences = {
                "Java is easy",
                "I love coding",
                "Data structures are important"
        };

        String word = "coding";

        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                System.out.println(sentence);
                return;
            }
        }
        System.out.println("Not Found");
    }
}

