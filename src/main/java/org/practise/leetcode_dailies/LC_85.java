package org.practise.leetcode_dailies;

import java.util.Stack;

public class LC_85 {

    public int[] NSR(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int pseudoIndex = n;
        int[] right = new int[n];
        for(int i=n-1; i>=0; i--) {
            if(stack.isEmpty()) {
                right[i] = pseudoIndex;
            } else {
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    right[i] = pseudoIndex;
                } else {
                    right[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        return right;
    }

    public int[] NSL(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int pseudoIndex = -1;
        int[] left = new int[n];
        for(int i=0; i<n; i++) {
            if(stack.isEmpty()) {
                left[i] = pseudoIndex;
            } else {
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    left[i] = pseudoIndex;
                } else {
                    left[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        return left;
    }

    public int MAH(int[] heights) {
        int n = heights.length;
        int[] right = NSR(heights);
        int[] left = NSL(heights);
        int[] width = new int[n];
        for(int i=0; i<n; i++) {
            width[i] = right[i] - left[i] - 1;
        }
        int maxArea = 0;
        for(int i=0; i<n; i++) {
            int area = width[i] * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        for(int i=0; i<col; i++) {
            heights[i] = (matrix[0][i] == '1') ? 1: 0;
        }
        int maxArea = MAH(heights);
        for(int i=1; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }
            maxArea = Math.max(maxArea, MAH(heights));
        }
        return maxArea;
    }

}
