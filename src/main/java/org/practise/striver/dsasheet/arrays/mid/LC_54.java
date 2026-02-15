package org.practise.striver.dsasheet.arrays.mid;

import java.util.ArrayList;
import java.util.List;

public class LC_54 {

    // 54. Spiral Matrix

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> list = new ArrayList<>();

        int left = 0, right = cols - 1;
        int top = 0, bottom = rows - 1;

        while(left<= right && top<=bottom) {
            // left -> right
            for(int i=left; i<=right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            // top -> bottom
            for(int i=top; i<=bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            // bottom -> left
            if(top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // bottom -> top
            if(left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }

}
