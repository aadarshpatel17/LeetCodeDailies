package org.practise.striver.dsasheet.linkedlist.medium;

import org.practise.striver.dsasheet.linkedlist.ListNode;

public class LC_234 {

    // 234. Palindrome Linked List
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(ListNode head) {
        // find mid
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = reverseLinkedList(slow.next);
        slow = head;
        while(mid != null) {
            if(slow.data != mid.data)
                return false;
            mid = mid.next;
            slow = slow.next;
        }
        return true;
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while(temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static ListNode reverseRecursively(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseRecursively(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

}
