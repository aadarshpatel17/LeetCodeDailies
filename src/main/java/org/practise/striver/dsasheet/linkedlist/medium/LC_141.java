package org.practise.striver.dsasheet.linkedlist.medium;

import org.practise.striver.dsasheet.linkedlist.Node;

public class LC_141 {

    // 141. Linked List Cycle
    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

}
