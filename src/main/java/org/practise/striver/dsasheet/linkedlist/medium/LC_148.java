package org.practise.striver.dsasheet.linkedlist.medium;

import org.practise.striver.dsasheet.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.practise.striver.dsasheet.linkedlist.medium.LC_206.arrayToLL;
import static org.practise.striver.dsasheet.linkedlist.medium.LC_206.traverse;

public class LC_148 {

    // 148. Sort List

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
//        Node head = new Node(nums[4]);
        ListNode head = arrayToLL(nums);
        head = sortList(head);
        traverse(head);
    }



    public static ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(list);

        temp = head;
        int i=0;
        while(temp != null) {
            temp.data = list.get(i++);
            temp = temp.next;
        }
        return head;
    }
}
