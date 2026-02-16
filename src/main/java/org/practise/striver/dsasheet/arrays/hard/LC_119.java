package org.practise.striver.dsasheet.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class LC_119 {
    // 119. Pascal's Triangle

    /*
        main formula is nCr
        1. Given the row and col, find value
        2. Given row, find all values
        3. Given n, print complete Pascal's Triangle till row n;
    */

    public static void main(String[] args) {
        // variation 1: Given the row and col, find value;
//        System.out.println(pascalVariationI(1, 0));

        // variation 2: Given row, find all values
//        System.out.println(pascalVariationII_novice(6));
//        System.out.println(pascalVariationII_optimized(6));

        // variation 3: Given n, print complete Pascal's Triangle till row n;
        System.out.println(pascalVariationIII(6));
    }

    public static long pascalVariationI(int row, int col) {
        long ans = 1;
        for (int i = 0; i < col; i++) {
            ans *= (row - 1) - i;
            ans /= i + 1;
        }
        return ans;
    }

    public static List<Long> pascalVariationII_novice(int row) {
        List<Long> ans = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            ans.add(pascalVariationI(row, i));
        }
        return ans;
    }

    public static List<Long> pascalVariationII_optimized(int row) {
        List<Long> list = new ArrayList<>();
        long ans = 1;
        list.add(ans);
        for (int i = 1; i < row; i++) {
            ans *= (row - i);
            ans /= i;
            list.add(ans);
        }
        return list;
    }

    public static List<List<Long>> pascalVariationIII(int row) {
        List<List<Long>> ans = new ArrayList<>();
        for (int i = 1; i <= row; i++) {
            ans.add(pascalVariationII_optimized(i));
        }
        return ans;
    }


}
