package org.practise.striver.dsasheet.linkedlist.DLL;


import org.practise.striver.dsasheet.linkedlist.NodeII;

public class Basics {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        NodeII head = arrayToDll(nums);

        head = insertAtKII(head, 99, 5);
        print(head);
    }

    // this is also correct 
    public static NodeII insertAtKII(NodeII head, int value, int k) {
        if(head == null) {
            if(k == 1)
                return new NodeII(value);
            else
                return null;
        }
        if(k == 1) {
            return insertAtHead(head, value);
        }
        int count = 1;
        NodeII temp = head;
        while(temp != null) {
            if(count == k-1) {
                NodeII nn = new NodeII(value);
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
    public static NodeII insertAtKI(NodeII head, int value, int k) {
        if(head == null) {
            if(k == 1)
                return new NodeII(value);
            else
                return null;
        }
        if(k == 1) {
            return insertAtHead(head, value);
        }
        int count = 1;
        NodeII temp = head;
        while(temp.next != null) {
            if(count == k-1) {
                NodeII nn = new NodeII(value);
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
    public static NodeII insertAtEnd(NodeII head, int value) {
        if (head == null) {
            return new NodeII(value);
        }
        NodeII temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        NodeII nn = new NodeII(value);
        temp.next = nn;
        nn.prev = temp;
        return head;
    }

    // insert at head
    public static NodeII insertAtHead(NodeII head, int value) {
        if (head == null) {
            return new NodeII(value);
        }
        NodeII nn = new NodeII(value);
        nn.next = head;
        nn.prev = null;
        head.prev = nn;
        return nn;
    }

    // array to DLL
    public static NodeII arrayToDll(int[] nums) {
        NodeII head = new NodeII(nums[0]);
        NodeII temp = head;
        for (int i = 1; i < nums.length; i++) {
            NodeII nn = new NodeII(nums[i]);
            temp.next = nn;
            nn.prev = temp;
            temp = nn;
        }
        return head;
    }

    // check if value is present
    public static boolean isPresent(NodeII head, int value) {
        NodeII temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // traverse
    public static void print(NodeII head) {
        NodeII temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
