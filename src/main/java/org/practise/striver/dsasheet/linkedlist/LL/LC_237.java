package org.practise.striver.dsasheet.linkedlist.LL;

import org.practise.striver.dsasheet.linkedlist.Node;

public class LC_237 {

    // 237. Delete Node in a Linked List

    public void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

}
