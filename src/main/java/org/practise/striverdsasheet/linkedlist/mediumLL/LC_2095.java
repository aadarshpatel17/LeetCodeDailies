package org.practise.striverdsasheet.linkedlist.mediumLL;

import org.practise.striverdsasheet.linkedlist.ListNode;

import static org.practise.striverdsasheet.linkedlist.PractiseI.print;
import static org.practise.striverdsasheet.linkedlist.mediumLL.LC_206.arrayToLL;

public class LC_2095 {

    // 2095. Delete the Middle Node of a Linked List

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        ListNode head = arrayToLL(nums);
        head = deleteMiddle(head);
        print(head);
    }


    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        ListNode prev = slow;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = prev.next.next;

        return head;
    }

}
