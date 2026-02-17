package org.practise.striver.dsasheet.linkedlist;

class Node {

    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Basics {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 5, 6, 4};
//        Node head = new Node(nums[4]);
        Node head = arrayToLL(nums);
        traverse(head);
        System.out.println();
        System.out.println("Length of LL: " + lengthOfLL(head));
        System.out.println("Check If Present: " + isPresent(head, 14));
        System.out.println("*******Insert At HEAD*******");
        head = insertAtHead(head, 100);
        traverse(head);
    }

    public static Node insertAtHead(Node head, int value) {
        Node temp = new Node(value);
        temp.next = head;
        return temp;
    }

    public static boolean isPresent(Node head, int value) {
        Node temp = head;
        while(temp != null) {
            if(temp.data == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static Node arrayToLL(int[] nums) {
        Node head = new Node(nums[0]);
        Node mover = head;
        for(int i=1; i<nums.length; i++) {
            Node temp = new Node(nums[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static int lengthOfLL(Node head) {
        int count = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static void traverse(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }


}
