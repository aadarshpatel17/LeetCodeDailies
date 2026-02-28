package org.practise.striver.dsasheet.linkedlist.medium;

import org.practise.striver.dsasheet.linkedlist.ListNode;

import static org.practise.striver.dsasheet.linkedlist.medium.LC_206.arrayToLL;
import static org.practise.striver.dsasheet.linkedlist.medium.LC_206.traverse;

public class SortLinkedList012 {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 0 , 1};
        ListNode head = arrayToLL(nums);

        head = sortList(head);

        traverse(head);
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode d1 = new ListNode(-1, null);
        ListNode d1Head = d1;
        ListNode d2 = new ListNode(-1, null);
        ListNode d2Head = d2;
        ListNode d3 = new ListNode(-1, null);
        ListNode d3Head = d3;

        ListNode temp = head;
        while(temp != null) {
            if(temp.data == 0) {
                d1.next = temp;
                d1 = temp;
            } else if(temp.data == 1) {
                d2.next = temp;
                d2 = temp;
            } else {
                d3.next = temp;
                d3 = temp;
            }
            temp = temp.next;
        }

        d1.next = d2Head.next;
        d2.next = d3Head.next;
        d3.next = null;

        return d1Head.next;
    }

}
