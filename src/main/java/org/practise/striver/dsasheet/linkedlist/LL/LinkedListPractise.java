package org.practise.striver.dsasheet.linkedlist.LL;

public class LinkedListPractise {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 5, 4};
        Node head = arrayToLL(nums);
        head = insertBeforeValue(head, 100, 3);
        traverse(head);
    }

    // delete head;
    public static Node deleteAtStart(Node head) {
        return (head == null) ? null : head.next;
    }

    // delete tail
    public static Node deleteAtEnd(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    // delete tail at index K
    public static Node deleteAtK(Node head, int k) {
        if (head == null) {
            return head;
        }
        if (k == 1) {
            return head.next;
        }
        Node temp = head;
        Node prev = null;
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
    public static Node deleteValue(Node head, int value) {
        if (head == null) {
            return head;
        }
        if (head.data == value) {
            return head.next;
        }
        Node temp = head;
        Node prev = null;
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
    public static Node insertAtStart(Node head, int value) {
        return new Node(value, head);
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

    // insert at kth place
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

    public static Node insertBeforeValue(Node head, int k, int value) {
        if (head == null) {
            return null;
        }
        if (head.data == value) {
            return new Node(k, head);
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == value) {
                Node newNode = new Node(k);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }


    // Find the length of the Linked List
    public static int lengthOfLL(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count += 1;
            temp = temp.next;
        }
        return count;
    }

    // Search in Linked List
    public static int search(Node head, int value) {
        Node temp = head;
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
    }

}
