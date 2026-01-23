package DataStructure.SortingAlgorithms;
public class BubbleSortStudentMarks {

    static void bubbleSort(int[] marks) {
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] marks = {78, 45, 89, 60, 72};

        bubbleSort(marks);

        System.out.println("Sorted Student Marks:");
        for (int m : marks)
            System.out.print(m + " ");
    }
}

