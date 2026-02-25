package org.practise.striver.dsasheet.linkedlist.medium;

import org.practise.striver.dsasheet.linkedlist.ListNode;

import java.util.Stack;

public class LC_206 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
//        Node head = new Node(nums[4]);
        ListNode head = arrayToLL(nums);
        head = reverseList_using_recursion(head);
        traverse(head);
    }

    public static ListNode reverse_pracII(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static ListNode reverseList_using_recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList_using_recursion(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseListII(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        ListNode stored = null;
        ListNode prev = null;
        while (temp != null) {
            stored = temp.next;
            temp.next = prev;
            prev = temp;
            temp = stored;
        }
        return prev;
    }

    // 206. Reverse Linked List
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        // create new LinkedList
        ListNode newList = new ListNode(stack.pop().data);
        temp = newList;
        while (!stack.isEmpty()) {
            ListNode nn = new ListNode(stack.pop().data);
            temp.next = nn;
            temp = nn;
        }

        return newList;
    }

    public static ListNode arrayToLL(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode mover = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void traverse(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


}
