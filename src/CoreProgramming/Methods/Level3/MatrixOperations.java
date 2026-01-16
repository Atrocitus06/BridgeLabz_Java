package core_programming.Methods.Level3;
/*
Write a program to perform matrix manipulation operations like addition, subtraction,
multiplication, and transpose. Also finding the determinant and inverse of a matrix.
The program should take random matrices as input and display the result of the operations.
Hint =>
Write a Method to create a random matrix taking rows and columns as parameters
Write a Method to add two matrices
Write a Method to subtract two matrices
Write a Method to multiply two matrices
Write a Method to find the transpose of a matrix
Write a Method to find the determinant of a 2x2 matrix
Write a Method to find the determinant of a 3x3 matrix
Write a Method to find the inverse of a 2x2 matrix
Write a Method to find the inverse of a 3x3 matrix
Write a Method to display a matrix
*/

import java.util.Scanner;

public class MatrixOperations {

    public static int[][] inputMatrix(int rows, int cols, Scanner sc) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] addMatrices(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < B.length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static int[][] transposeMatrix(int[][] A) {
        int[][] T = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                T[j][i] = A[i][j];
            }
        }
        return T;
    }

    public static int determinant2x2(int[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    public static int determinant3x3(int[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
                - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
                + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    public static double[][] inverse2x2(int[][] m) {
        int det = determinant2x2(m);
        if (det == 0) return null;

        double[][] inv = new double[2][2];
        inv[0][0] =  m[1][1] / (double) det;
        inv[0][1] = -m[0][1] / (double) det;
        inv[1][0] = -m[1][0] / (double) det;
        inv[1][1] =  m[0][0] / (double) det;
        return inv;
    }

    public static double[][] inverse3x3(int[][] m) {
        int det = determinant3x3(m);
        if (det == 0) return null;

        double[][] inv = new double[3][3];

        inv[0][0] =  (m[1][1]*m[2][2]-m[1][2]*m[2][1])/(double)det;
        inv[0][1] = -(m[0][1]*m[2][2]-m[0][2]*m[2][1])/(double)det;
        inv[0][2] =  (m[0][1]*m[1][2]-m[0][2]*m[1][1])/(double)det;

        inv[1][0] = -(m[1][0]*m[2][2]-m[1][2]*m[2][0])/(double)det;
        inv[1][1] =  (m[0][0]*m[2][2]-m[0][2]*m[2][0])/(double)det;
        inv[1][2] = -(m[0][0]*m[1][2]-m[0][2]*m[1][0])/(double)det;

        inv[2][0] =  (m[1][0]*m[2][1]-m[1][1]*m[2][0])/(double)det;
        inv[2][1] = -(m[0][0]*m[2][1]-m[0][1]*m[2][0])/(double)det;
        inv[2][2] =  (m[0][0]*m[1][1]-m[0][1]*m[1][0])/(double)det;

        return inv;
    }

    public static void displayDoubleMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%.2f\t", val);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        System.out.println("\nEnter Matrix A:");
        int[][] A = inputMatrix(rows, cols, sc);

        System.out.println("\nEnter Matrix B:");
        int[][] B = inputMatrix(rows, cols, sc);

        System.out.println("\nMatrix A:");
        displayMatrix(A);

        System.out.println("Matrix B:");
        displayMatrix(B);

        System.out.println("A + B:");
        displayMatrix(addMatrices(A, B));

        System.out.println("A - B:");
        displayMatrix(subtractMatrices(A, B));

        if (A[0].length == B.length) {
            System.out.println("A x B:");
            displayMatrix(multiplyMatrices(A, B));
        } else {
            System.out.println("Matrix multiplication not possible.");
        }

        System.out.println("Transpose of A:");
        displayMatrix(transposeMatrix(A));

        if (rows == 2 && cols == 2) {
            System.out.println("Determinant of A: " + determinant2x2(A));
            double[][] inv2 = inverse2x2(A);
            if (inv2 != null) {
                System.out.println("Inverse of A:");
                displayDoubleMatrix(inv2);
            }
        }

        if (rows == 3 && cols == 3) {
            System.out.println("Determinant of A: " + determinant3x3(A));
            double[][] inv3 = inverse3x3(A);
            if (inv3 != null) {
                System.out.println("Inverse of A:");
                displayDoubleMatrix(inv3);
            }
        }

        sc.close();
    }
}

