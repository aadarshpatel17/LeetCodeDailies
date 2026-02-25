package org.practise.striver.dsasheet.linkedlist;

public class PractiseI {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        ListNode head = arrayToLL(nums);
        head = insertAfterValue(head, 4, 100);
        print(head);
    }

    // insert after value;
    public static ListNode insertAfterValue(ListNode head, int value, int nodeValue) {
        if (head == null)
            return null;
        ListNode temp = head;
        while (temp != null) {
            if(temp.data == value) {    
                ListNode nn = new ListNode(nodeValue);
                nn.next = temp.next;
                temp.next = nn;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // insert before value;
    public static ListNode insertBeforeValue(ListNode head, int value, int nodeValue) {
        if (head == null) {
            return null;
        }
        if (head.data == value) {
            return new ListNode(nodeValue, head);
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.data == value) {
                ListNode newNode = new ListNode(nodeValue);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // insert at index k
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

    // insert at head
    public static ListNode insertAtHead(ListNode head, int value) {
        return new ListNode(value, head);
    }

    // array to LL
    public static ListNode arrayToLL(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode newNode = new ListNode(nums[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }

    // check if the element is present or not;
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

    // traverse
    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
