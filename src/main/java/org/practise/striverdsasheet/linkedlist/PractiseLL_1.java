package org.practise.striverdsasheet.linkedlist;

public class PractiseLL_1 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = arrayToLL(nums);

        head = insertAtEnd(head, 6);
        traverse(head);
    }

    public static ListNode insertAtEnd(ListNode head, int data) {
        if(head == null) return new ListNode(data);
        ListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(data);
        return head;
    }

    public static ListNode insertAtHead(ListNode head, int data) {
        if(head == null) return new ListNode(data);
        return new ListNode(data, head);
    }

    public static ListNode arrayToLL(int[] nums) {
        int n = nums.length;
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;
        for(int i=1; i<n; i++) {
            ListNode newNode = new ListNode(nums[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }

    public static void traverse(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
