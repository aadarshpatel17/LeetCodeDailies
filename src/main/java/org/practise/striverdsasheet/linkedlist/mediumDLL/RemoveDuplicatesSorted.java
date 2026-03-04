package org.practise.striverdsasheet.linkedlist.mediumDLL;

import org.practise.striverdsasheet.linkedlist.ListNodeDLL;

import static org.practise.striverdsasheet.linkedlist.DLL.RerveseDLL.arrayToDll;
import static org.practise.striverdsasheet.linkedlist.DLL.RerveseDLL.print;

public class RemoveDuplicatesSorted {

    // https://takeuforward.org/data-structure/remove-duplicates-from-sorted-dll

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4, 4, 5, 5, 6};
        ListNodeDLL head = arrayToDll(nums);
        head = removeDuplicates_optimized(head);
        print(head);
    }

    public static ListNodeDLL removeDuplicates_optimized(ListNodeDLL head) {
        if (head == null) return null;
        ListNodeDLL current = head;
        while(current != null && current.next != null) {
            ListNodeDLL nextDistinct = current.next;
            while(nextDistinct != null && nextDistinct.val == current.val) {
                nextDistinct = nextDistinct.next;
            }
            current.next = nextDistinct;
            if(nextDistinct != null) {
                nextDistinct.prev = current;
            }
            current = current.next;
        }
        return head;
    }

    public static ListNodeDLL removeDuplicates(ListNodeDLL head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNodeDLL i = head;
        ListNodeDLL j = head.next;

        while (j != null) {
            if(i.val != j.val) {
                i = i.next;
                if(i != j) {
                    ListNodeDLL prev = i.prev;
                    ListNodeDLL next = i.next;
                    prev.next = next;
                    next.prev = prev;
                    i = next;
                }
            }
            j = j.next;
        }
        return head;
    }

}
