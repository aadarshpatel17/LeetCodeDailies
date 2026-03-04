package org.practise.striverdsasheet.linkedlist.mediumLL;

import org.practise.striverdsasheet.linkedlist.ListNode;

public class LC_876 {

    // 876. Middle of the Linked List
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
