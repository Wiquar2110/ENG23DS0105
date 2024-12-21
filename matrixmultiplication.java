import java.util.Scanner;

public class matrixmultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for the first matrix
        System.out.println("Enter the number of rows for 1st matrix:");
        int r1 = sc.nextInt();
        System.out.println("Enter the number of columns for 1st matrix:");
        int c1 = sc.nextInt();
        int[][] matrix1 = new int[r1][c1];

        System.out.println("Enter 1st matrix elements:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        // Input for the second matrix
        System.out.println("Enter the number of rows in 2nd matrix:");
        int r2 = sc.nextInt();
        System.out.println("Enter the number of columns in 2nd matrix:");
        int c2 = sc.nextInt();
        int[][] matrix2 = new int[r2][c2];

        System.out.println("Enter 2nd matrix elements:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        // Check if matrix multiplication is possible
        if (c1 != r2) {
            System.out.println("Matrix multiplication is not possible. The number of columns in the first matrix must equal the number of rows in the second matrix.");
            return;
        }

        // Resultant matrix of size r1 x c2
        int[][] resultant = new int[r1][c2];

        // Matrix multiplication logic
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                resultant[i][j] = 0;  // Initialize the result element
                for (int k = 0; k < c1; k++) {  // c1 == r2
                    resultant[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        // Print the resultant matrix
        System.out.println("Resultant matrix:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(resultant[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
