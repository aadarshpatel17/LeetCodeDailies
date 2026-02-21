package org.practise.striver.dsasheet.linkedlist.DLL;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class Basics {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Node head = arrayToDll(nums);

        head = insertAtKII(head, 99, 5);
        print(head);
    }

    // this is also correct 
    public static Node insertAtKII(Node head, int value, int k) {
        if(head == null) {
            if(k == 1)
                return new Node(value);
            else
                return null;
        }
        if(k == 1) {
            return insertAtHead(head, value);
        }
        int count = 1;
        Node temp = head;
        while(temp != null) {
            if(count == k-1) {
                Node nn = new Node(value);
                nn.next = temp.next;
                if(temp.next != null)
                    temp.next.prev = nn;
                nn.prev = temp;
                temp.next = nn;
                break;
            }
            count++;
            temp = temp.next;
        }
        return head;
    }

    // this is also correct
    public static Node insertAtKI(Node head, int value, int k) {
        if(head == null) {
            if(k == 1)
                return new Node(value);
            else
                return null;
        }
        if(k == 1) {
            return insertAtHead(head, value);
        }
        int count = 1;
        Node temp = head;
        while(temp.next != null) {
            if(count == k-1) {
                Node nn = new Node(value);
                nn.next = temp.next;
                temp.next.prev = nn;
                nn.prev = temp;
                temp.next = nn;
                count = 0;
                break;
            }
            count++;
            temp = temp.next;
        }
        if(count == k-1) {
            return insertAtEnd(head, value);
        }
        return head;
    }

    // insert at end
    public static Node insertAtEnd(Node head, int value) {
        if (head == null) {
            return new Node(value);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node nn = new Node(value);
        temp.next = nn;
        nn.prev = temp;
        return head;
    }

    // insert at head
    public static Node insertAtHead(Node head, int value) {
        if (head == null) {
            return new Node(value);
        }
        Node nn = new Node(value);
        nn.next = head;
        nn.prev = null;
        head.prev = nn;
        return nn;
    }

    // array to DLL
    public static Node arrayToDll(int[] nums) {
        Node head = new Node(nums[0]);
        Node temp = head;
        for (int i = 1; i < nums.length; i++) {
            Node nn = new Node(nums[i]);
            temp.next = nn;
            nn.prev = temp;
            temp = nn;
        }
        return head;
    }

    // check if value is present
    public static boolean isPresent(Node head, int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // traverse
    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
