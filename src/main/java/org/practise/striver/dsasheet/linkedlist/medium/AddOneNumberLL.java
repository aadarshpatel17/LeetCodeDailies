package org.practise.striver.dsasheet.linkedlist.medium;

import org.practise.striver.dsasheet.linkedlist.ListNode;

import static org.practise.striver.dsasheet.linkedlist.PractiseI.print;
import static org.practise.striver.dsasheet.linkedlist.medium.LC_206.arrayToLL;

public class AddOneNumberLL {
    // Add one to a number represented by LL
    public static void main(String[] args) {
        int[] nums = new int[]{9};
        ListNode head = arrayToLL(nums);
        head = addOne_better1(head);
        print(head);
    }

    public static ListNode addOne_better1(ListNode head) {
        head = reverse(head);
        ListNode temp = head;
        int carry = 1;
        while (temp != null && carry > 0) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;

            // if there's no next node and we still have a carry
            // add new node
            if(temp.next == null && carry > 0) {
                temp.next = new ListNode(carry);
                carry = 0;
            }
            temp = temp.next;
        }
        return reverse(head);
    }

    public static ListNode addOne_better(ListNode head) {
        head = reverse(head);
        ListNode temp = head;
        int carry = 1;
        while (temp != null) {
            temp.data += carry;
            if (temp.data < 10) {
                carry = 0;
                break;
            } else {
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }
        if (carry == 1) {
            ListNode nn = new ListNode(1);
            head = reverse(head);
            nn.next = head;
            return nn;
        }
        return reverse(head);
    }


    public static ListNode addOne(ListNode head) {
        head = reverse(head);
        ListNode temp = head;
        ListNode prev = null;
        int carry = 0;
        while (temp != null) {
            if (temp.data < 9) {
                temp.data = temp.data + carry + 1;
                break;
            } else {
                temp.data = 0;
                carry = 1;
            }
            prev = temp;
            temp = temp.next;
        }
        if (carry > 0) {
            prev.next = new ListNode(1);
        }
        return reverse(head);
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
}
