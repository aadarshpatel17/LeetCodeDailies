package org.practise.striver.dsasheet.linkedlist.medium;

import org.practise.striver.dsasheet.linkedlist.ListNode;

import static org.practise.striver.dsasheet.linkedlist.PractiseI.print;
import static org.practise.striver.dsasheet.linkedlist.medium.LC_206.arrayToLL;

public class LC_328 {

    // 328. Odd Even Linked List

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = arrayToLL(nums);
        head = oddEvenList(head);
        print(head);
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenStarting = even;

        while(odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }

        odd.next = evenStarting;

        return head;
    }

}
