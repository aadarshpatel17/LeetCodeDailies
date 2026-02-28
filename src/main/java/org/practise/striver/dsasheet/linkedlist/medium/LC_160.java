package org.practise.striver.dsasheet.linkedlist.medium;

import org.practise.striver.dsasheet.linkedlist.ListNode;

import java.util.HashMap;

import static org.practise.striver.dsasheet.linkedlist.medium.LC_206.arrayToLL;
import static org.practise.striver.dsasheet.linkedlist.medium.LC_206.traverse;

public class LC_160 {

    // LC_160. Intersection of Two Linked Lists

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 8, 4, 5};
        int[] nums2 = new int[]{5, 6, 1, 8, 4, 5};
        ListNode head1 = arrayToLL(nums1);
        ListNode head2 = arrayToLL(nums2);

        ListNode head = getIntersectionNode_approachIII(head1, head2);

        traverse(head);
    }

    public static ListNode getIntersectionNode_approachIII(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;

        while (t1 != t2) {
            if(t1 == null) {
                t1 = headB;
            }
            if(t2 == null) {
                t2 = headA;
            }
            t1 = t1.next;
            t2 = t2.next;
        }

        return t1;
    }

    public static ListNode getIntersectionNode_approachII(ListNode headA, ListNode headB) {
        int len1 = findLengthLL(headA);
        int len2 = findLengthLL(headB);
        if (len1 < len2) {
            return collisionPoint(headA, headB, len2 - len1);
        } else {
            return collisionPoint(headB, headA, len1 - len2);
        }
    }

    public static ListNode collisionPoint(ListNode smaller, ListNode bigger, int diff) {
        // move bigger to diff len first
        while (diff != 0) {
            diff--;
            bigger = bigger.next;
        }

        // now compare both list, since they have same length now
        while (bigger != smaller) {
            smaller = smaller.next;
            bigger = bigger.next;
        }
        return bigger;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode temp = headA;
        while (temp != null) {
            map.put(temp, 1);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static int findLengthLL(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

}
