package org.practise.striver.dsasheet.linkedlist.LL;

import org.practise.striver.dsasheet.linkedlist.ListNode;

public class LinkedListPractise {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 5, 4};
        ListNode head = arrayToLL(nums);
        head = insertBeforeValue(head, 100, 3);
        traverse(head);
    }

    // delete head;
    public static ListNode deleteAtStart(ListNode head) {
        return (head == null) ? null : head.next;
    }

    // delete tail
    public static ListNode deleteAtEnd(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    // delete tail at index K
    public static ListNode deleteAtK(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        if (k == 1) {
            return head.next;
        }
        ListNode temp = head;
        ListNode prev = null;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    // delete with value
    public static ListNode deleteValue(ListNode head, int value) {
        if (head == null) {
            return head;
        }
        if (head.data == value) {
            return head.next;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            if (temp.data == value) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    // insertion at the head of Linked List
    public static ListNode insertAtStart(ListNode head, int value) {
        return new ListNode(value, head);
    }

    // insert at end
    public static ListNode insertAtEnd(ListNode head, int value) {
        if (head == null) {
            return new ListNode(value);
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(value);
        return head;
    }

    // insert at kth place
    public static ListNode insertAtK(ListNode head, int k, int value) {
        if (head == null) {
            if (k == 1) {
                return new ListNode(value);
            } else {
                return null;
            }
        }
        if (k == 1) {
            return new ListNode(value, head);
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            if (count == k - 1) {
                ListNode newNode = new ListNode(value);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static ListNode insertBeforeValue(ListNode head, int k, int value) {
        if (head == null) {
            return null;
        }
        if (head.data == value) {
            return new ListNode(k, head);
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.data == value) {
                ListNode newNode = new ListNode(k);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }


    // Find the length of the Linked List
    public static int lengthOfLL(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count += 1;
            temp = temp.next;
        }
        return count;
    }

    // Search in Linked List
    public static int search(ListNode head, int value) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (temp.data == value) {
                return count;
            }
            temp = temp.next;
        }
        return -1;
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
    }

}
