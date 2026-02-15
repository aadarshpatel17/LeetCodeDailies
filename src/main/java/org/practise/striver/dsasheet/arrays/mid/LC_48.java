package org.practise.striver.dsasheet.arrays.mid;

public class LC_48 {
    // 48 . Rotate Image

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        // BF
//        rotate(matrix);
        // Optimal: Transpose + reverse
        transposeArray(matrix);
        reverseArray(matrix);
        print(matrix, matrix.length, matrix[0].length);
    }

    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[j][row - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = result[i][j];
            }
        }

        print(result, row, col);
    }

    public static void transposeArray(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                // swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void reverseArray(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0; i<row; i++) {
            int left = 0, right = col-1;
            while(left < right) {
                // swap
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++; right--;
            }
        }
    }

    public static void print(int[][] matrix, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
