package org.practise.striverdsasheet.linkedlist.mediumDLL;

import org.practise.striverdsasheet.linkedlist.ListNodeDLL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.practise.striverdsasheet.linkedlist.DLL.RerveseDLL.arrayToDll;
import static org.practise.striverdsasheet.linkedlist.DLL.RerveseDLL.print;

public class FindPairs {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6, 8, 9};
        ListNodeDLL head = arrayToDll(nums);

        System.out.println(findPairsWithGivenSum_O(head, 7));
    }

    public static List<List<Integer>> findPairsWithGivenSum_O(ListNodeDLL head, int target) {
        List<List<Integer>> list = new ArrayList<>();

        ListNodeDLL left = head;
        ListNodeDLL right = findTail(head);

        while(left.val < right.val) {
            int sum = left.val + right.val;
            if(sum == target) {
                list.add(List.of(left.val, right.val));
                left = left.next;
                right = right.prev;
            } else if(sum < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }

        return list;
    }

    public static List<List<Integer>> findPairsWithGivenSum_BF(ListNodeDLL head, int target) {
        List<List<Integer>> list = new ArrayList<>();
        ListNodeDLL temp = head;
        while (temp != null) {
            ListNodeDLL j = temp.next;
            while (j != null && (temp.val + j.val <= target)) {
                int sum = temp.val + j.val;
                if (sum == target) {
                    list.add(Arrays.asList(temp.val, j.val));
                }
                j = j.next;
            }
            temp = temp.next;
        }
        return list;
    }

    public static ListNodeDLL findTail(ListNodeDLL head) {
        ListNodeDLL temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
}
