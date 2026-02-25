package org.practise.striver.dsasheet.linkedlist.LL;

import org.practise.striver.dsasheet.linkedlist.ListNode;

public class Basics {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 5, 6, 4};
//        Node head = new Node(nums[4]);
        ListNode head = arrayToLL(nums);
        traverse(head);
        System.out.println();
        System.out.println("Length of LL: " + lengthOfLL(head));
        System.out.println("Check If Present: " + isPresent(head, 4));
        System.out.println("*******Insert At HEAD*******");
        head = insertAtHead(head, 100);
        traverse(head);
    }

    public static ListNode insertAtHead(ListNode head, int value) {
        return new ListNode(value, head);
    }

    public static boolean isPresent(ListNode head, int value) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
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

    public static int lengthOfLL(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void traverse(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }


}
