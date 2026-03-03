package org.practise.striver.dsasheet.linkedlist.LL;

import org.practise.striver.dsasheet.linkedlist.ListNode;

public class LC_237 {

    // 237. Delete Node in a Linked List

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
