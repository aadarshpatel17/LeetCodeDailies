package org.practise.striver.dsasheet.linkedlist.medium;

import org.practise.striver.dsasheet.linkedlist.ListNode;

import static org.practise.striver.dsasheet.linkedlist.PractiseI.print;
import static org.practise.striver.dsasheet.linkedlist.medium.LC_206.arrayToLL;

public class LC_2 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{9, 9, 9, 9, 9, 9, 9};
        int[] nums2 = new int[]{9, 9, 9, 9};
        ListNode l1 = arrayToLL(nums1);
        ListNode l2 = arrayToLL(nums2);
        ListNode head = addTwoNumbers_optimize(l1, l2);
        print(head);
    }

    public static ListNode addTwoNumbers_optimize(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode t1 = l1;
        ListNode t2 = l2;

        ListNode sumLL = new ListNode(-1);
        ListNode temp = sumLL;

        int carry = 0;
        while (t1 != null && t2 != null) {
            int sum = t1.data + t2.data + carry;
            ListNode nn = new ListNode(sum % 10);
            carry = sum / 10;
            temp.next = nn;
            temp = nn;
            t1 = t1.next;
            t2 = t2.next;
        }

        while (t1 != null) {
            int sum = t1.data + carry;
            ListNode nn = new ListNode(sum % 10);
            carry = sum / 10;
            temp.next = nn;
            t1 = t1.next;
            temp = nn;
        }
        while (t2 != null) {
            int sum = t2.data + carry;
            ListNode nn = new ListNode(sum % 10);
            carry = sum / 10;
            temp.next = nn;
            t2 = t2.next;
            temp = nn;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return reverse(sumLL.next);
    }

    public static ListNode reverse(ListNode head) {
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

}
