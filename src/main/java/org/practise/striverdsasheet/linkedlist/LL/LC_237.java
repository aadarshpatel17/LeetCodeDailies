package org.practise.striverdsasheet.linkedlist.LL;

import org.practise.striverdsasheet.linkedlist.ListNode;

public class LC_237 {

    // 237. Delete Node in a Linked List

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
