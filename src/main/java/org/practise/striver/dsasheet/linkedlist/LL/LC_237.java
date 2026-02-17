package org.practise.striver.dsasheet.linkedlist.LL;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class LC_237 {

    // 237. Delete Node in a Linked List

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
