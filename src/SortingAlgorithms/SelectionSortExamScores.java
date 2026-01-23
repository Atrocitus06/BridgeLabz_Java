package DataStructure.SortingAlgorithms;

public class SelectionSortExamScores {

    static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex])
                    minIndex = j;
            }

            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] scores = {88, 74, 91, 65, 82};

        selectionSort(scores);

        System.out.println("Sorted Exam Scores:");
        for (int s : scores)
            System.out.print(s + " ");
    }
}
