package org.practise.striver.dsasheet.linkedlist.medium;

import org.practise.striver.dsasheet.linkedlist.Node;

import java.util.Stack;

public class LC_206 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
//        Node head = new Node(nums[4]);
        Node head = arrayToLL(nums);
        head = reverseList_using_recursion(head);
        traverse(head);
    }

    public static Node reverseList_using_recursion(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseList_using_recursion(head.next);
        Node front = head.next;
        front.next = head;
        head.next =  null;
        return newHead;
    }

    public static Node reverseListII(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        Node stored = null;
        Node prev = null;
        while (temp != null) {
            stored = temp.next;
            temp.next = prev;
            prev = temp;
            temp = stored;
        }
        return prev;
    }

    // 206. Reverse Linked List
    public static Node reverseList(Node head) {
        if (head == null) return null;
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        // create new LinkedList
        Node newList = new Node(stack.pop().data);
        temp = newList;
        while (!stack.isEmpty()) {
            Node nn = new Node(stack.pop().data);
            temp.next = nn;
            temp = nn;
        }

        return newList;
    }

    public static Node arrayToLL(int[] nums) {
        Node head = new Node(nums[0]);
        Node mover = head;
        for (int i = 1; i < nums.length; i++) {
            Node temp = new Node(nums[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void traverse(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


}
