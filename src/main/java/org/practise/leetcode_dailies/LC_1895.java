package org.practise.leetcode_dailies;

public class LC_1895 {

    // 1895. Largest Magic Square
    public int largestMagicSquare(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Row wise prefix sum
        int[][] rowCumSum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            rowCumSum[i][0] = grid[i][0];
            for (int j = 1; j < cols; j++) {
                rowCumSum[i][j] = rowCumSum[i][j - 1] + grid[i][j];
            }
        }

        // Column wise prefix sum
        int[][] colCumSum = new int[rows][cols];
        for (int j = 0; j < cols; j++) {
            colCumSum[0][j] = grid[0][j];
            for (int i = 1; i < rows; i++) {
                colCumSum[i][j] = colCumSum[i - 1][j] + grid[i][j];
            }
        }

        // Try square sizes from largest to smallest
        for (int side = Math.min(rows, cols); side >= 2; side--) {
            // Top-left corner of square
            for (int i = 0; i + side - 1 < rows; i++) {
                for (int j = 0; j + side - 1 < cols; j++) {
                    int targetSum = rowCumSum[i][j + side - 1] - (j > 0 ? rowCumSum[i][j - 1] : 0);

                    boolean allSame = true;

                    // check all rows
                    for (int r = i + 1; r < i + side; r++) {
                        int rowSum = rowCumSum[r][j + side - 1] - (j > 0 ? rowCumSum[r][j - 1] : 0);
                        if (rowSum != targetSum) {
                            allSame = false;
                            break;
                        }
                    }
                    if (!allSame) {
                        continue;
                    }

                    // check all cols
                    for (int c = j; c < j + side; c++) {
                        int colSum = colCumSum[i + side - 1][c] - (i > 0 ? colCumSum[i - 1][c] : 0);
                        if (colSum != targetSum) {
                            allSame = false;
                            break;
                        }
                    }

                    if (!allSame) {
                        continue;
                    }

                    // check diagonals
                    int diagonal = 0, antiDiagonal = 0;
                    for (int k = 0; k < side; k++) {
                        diagonal += grid[i + k][j + k];
                        antiDiagonal += grid[i + k][j + side - 1 - k];
                    }
                    if (diagonal == targetSum && antiDiagonal == targetSum) {
                        return side;
                    }
                }
            }
        }
        return 1;
    }

}
