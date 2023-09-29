import java.util.Random;
import java.util.Scanner;

public class Task4 {

    private static int[][] generate(int row, int col, int min, int max) {

        Random rand = new Random();
        int[][] m = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }

        return m;
    }
    private static void print(int[][] r) {
        for (int[] ints : r) {
            for (int j = 0; j < r[0].length; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();
        }
    }
    public static void multiply() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter matrix #1's column count and matrix #2's row count: ");
        int col1 = Integer.parseInt(scan.nextLine());

        System.out.print("Enter matrix #1's row count: ");
        int row1 = Integer.parseInt(scan.nextLine());

        System.out.print("Enter matrix #2's column count: ");
        int col2 = Integer.parseInt(scan.nextLine());

        System.out.print("Enter the minimum value: ");
        int min = Integer.parseInt(scan.nextLine());

        System.out.print("Enter the maximum value: ");
        int max = Integer.parseInt(scan.nextLine());

        int[][] m1 = generate(row1, col1, min, max);
        int[][] m2 = generate(col1, col2, min, max);
        int[][] r = new int[row1][col2];

        System.out.println("\nMatrix #1:\n");
        print(m1);
        System.out.println("\nMatrix #2:\n");
        print(m2);

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    r[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        System.out.println("\nResult:\n");
        print(r);
    }
}
