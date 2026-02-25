package org.practise.striver.dsasheet.linkedlist.LL;

import org.practise.striver.dsasheet.linkedlist.ListNode;

public class LC_237 {

    // 237. Delete Node in a Linked List

    public void deleteNode(ListNode node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

}
