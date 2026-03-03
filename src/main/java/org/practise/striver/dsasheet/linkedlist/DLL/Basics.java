package org.practise.striver.dsasheet.linkedlist.DLL;


import org.practise.striver.dsasheet.linkedlist.ListNodeDLL;

public class Basics {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ListNodeDLL head = arrayToDll(nums);

        head = insertAtKII(head, 99, 5);
        print(head);
    }

    // this is also correct 
    public static ListNodeDLL insertAtKII(ListNodeDLL head, int value, int k) {
        if(head == null) {
            if(k == 1)
                return new ListNodeDLL(value);
            else
                return null;
        }
        if(k == 1) {
            return insertAtHead(head, value);
        }
        int count = 1;
        ListNodeDLL temp = head;
        while(temp != null) {
            if(count == k-1) {
                ListNodeDLL nn = new ListNodeDLL(value);
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
    public static ListNodeDLL insertAtKI(ListNodeDLL head, int value, int k) {
        if(head == null) {
            if(k == 1)
                return new ListNodeDLL(value);
            else
                return null;
        }
        if(k == 1) {
            return insertAtHead(head, value);
        }
        int count = 1;
        ListNodeDLL temp = head;
        while(temp.next != null) {
            if(count == k-1) {
                ListNodeDLL nn = new ListNodeDLL(value);
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
    public static ListNodeDLL insertAtEnd(ListNodeDLL head, int value) {
        if (head == null) {
            return new ListNodeDLL(value);
        }
        ListNodeDLL temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        ListNodeDLL nn = new ListNodeDLL(value);
        temp.next = nn;
        nn.prev = temp;
        return head;
    }

    // insert at head
    public static ListNodeDLL insertAtHead(ListNodeDLL head, int value) {
        if (head == null) {
            return new ListNodeDLL(value);
        }
        ListNodeDLL nn = new ListNodeDLL(value);
        nn.next = head;
        nn.prev = null;
        head.prev = nn;
        return nn;
    }

    // array to DLL
    public static ListNodeDLL arrayToDll(int[] nums) {
        ListNodeDLL head = new ListNodeDLL(nums[0]);
        ListNodeDLL temp = head;
        for (int i = 1; i < nums.length; i++) {
            ListNodeDLL nn = new ListNodeDLL(nums[i]);
            temp.next = nn;
            nn.prev = temp;
            temp = nn;
        }
        return head;
    }

    // check if value is present
    public static boolean isPresent(ListNodeDLL head, int value) {
        ListNodeDLL temp = head;
        while (temp != null) {
            if (temp.val == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // traverse
    public static void print(ListNodeDLL head) {
        ListNodeDLL temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
