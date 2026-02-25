package org.practise.striver.dsasheet.linkedlist.medium;

import org.practise.striver.dsasheet.linkedlist.Node;

public class LC_142 {

//    142. Linked List Cycle II
    public Node detectCycle(Node head) {
        if(head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

}
