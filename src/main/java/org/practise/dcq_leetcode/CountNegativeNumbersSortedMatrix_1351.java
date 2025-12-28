package org.practise.dcq_leetcode;

public class CountNegativeNumbersSortedMatrix_1351 {
    public int countNegatives(int[][] grid) {
        int countNigga = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] < 0) {
                    countNigga++;
                }
            }
        }
        return countNigga;
    }
}
