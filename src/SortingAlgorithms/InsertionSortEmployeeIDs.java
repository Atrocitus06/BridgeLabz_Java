package DataStructure.SortingAlgorithms;

public class InsertionSortEmployeeIDs {
        public static void main(String[] args) {

            int[] empIds = {104, 101, 105, 102, 103};

            for (int i = 1; i < empIds.length; i++) {
                int key = empIds[i];
                int j = i - 1;

                while (j >= 0 && empIds[j] > key) {
                    empIds[j + 1] = empIds[j];
                    j--;
                }

                empIds[j + 1] = key;
            }

            // Display sorted employee IDs
            System.out.println("Sorted Employee IDs:");
            for (int id : empIds) {
                System.out.print(id + " ");
            }
        }
    }

