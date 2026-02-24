package org.practise.striver.dsasheet.linkedlist.medium;

import org.practise.striver.dsasheet.linkedlist.Node;

public class LC_876 {

    // 876. Middle of the Linked List
    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
