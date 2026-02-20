package org.practise.striver.dsasheet.linkedlist;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class PractiseI {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        Node head = arrayToLL(nums);
        head = insertAfterValue(head, 4, 100);
        print(head);
    }

    // insert after value;
    public static Node insertAfterValue(Node head, int value, int nodeValue) {
        if (head == null)
            return null;
        Node temp = head;
        while (temp != null) {
            if(temp.data == value) {    
                Node nn = new Node(nodeValue);
                nn.next = temp.next;
                temp.next = nn;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // insert before value;
    public static Node insertBeforeValue(Node head, int value, int nodeValue) {
        if (head == null) {
            return null;
        }
        if (head.data == value) {
            return new Node(nodeValue, head);
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == value) {
                Node newNode = new Node(nodeValue);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // insert at index k
    public static Node insertAtK(Node head, int k, int value) {
        if (head == null) {
            if (k == 1) {
                return new Node(value);
            } else {
                return null;
            }
        }
        if (k == 1) {
            return new Node(value, head);
        }
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            if (count == k - 1) {
                Node newNode = new Node(value);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
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
        temp.next = new Node(value);
        return head;
    }

    // insert at head
    public static Node insertAtHead(Node head, int value) {
        return new Node(value, head);
    }

    // array to LL
    public static Node arrayToLL(int[] nums) {
        Node head = new Node(nums[0]);
        Node temp = head;
        for (int i = 1; i < nums.length; i++) {
            Node newNode = new Node(nums[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }

    // check if the element is present or not;
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
