package org.practise.striverdsasheet.linkedlist.mediumLL;

import org.practise.striverdsasheet.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.practise.striverdsasheet.linkedlist.mediumLL.LC_206.arrayToLL;
import static org.practise.striverdsasheet.linkedlist.mediumLL.LC_206.traverse;

public class LC_148 {

    // 148. Sort List

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = arrayToLL(nums);

        head = merge_sort(head);

        traverse(head);
    }

    public static ListNode merge_sort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // find middle
        ListNode mid = findMid(head);

        // split into 2 halve
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = head;

        // recursively sort both halves
        left = merge_sort(left);
        right = merge_sort(right);

        // merge the sorted ll
        return merge(left, right);
    }

    public static ListNode merge(ListNode node1, ListNode node2) {
        // Create a dummy node
        ListNode dummyNode = new ListNode(-1, null);

        // Temp pointer to build merged list
        ListNode temp = dummyNode;

        // Traverse both lists
        while (node1 != null && node2 != null) {
            // choose smaller value
            if (node1.val <= node2.val) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            // Move temp pointer
            temp = temp.next;
        }

        // Attach remaining nodes
        if (node1 != null) {
            temp.next = node1;
        } else {
            temp.next = node2;
        }
        return dummyNode.next;
    }

    public static ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(list);

        temp = head;
        int i = 0;
        while (temp != null) {
            temp.val = list.get(i++);
            temp = temp.next;
        }
        return head;
    }
}
