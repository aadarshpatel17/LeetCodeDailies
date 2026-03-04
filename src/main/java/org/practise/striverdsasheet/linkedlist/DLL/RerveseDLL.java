package org.practise.striverdsasheet.linkedlist.DLL;

import org.practise.striverdsasheet.linkedlist.ListNodeDLL;

import java.util.Stack;

public class RerveseDLL {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNodeDLL head = arrayToDll(nums);

        head = reverse_usingIteration(head);
        print(head);
    }

    public static ListNodeDLL reverse_usingIteration(ListNodeDLL head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNodeDLL prev = null;
        ListNodeDLL temp = head;
        while(temp != null) {
            ListNodeDLL front = temp.next;
            temp.prev = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static ListNodeDLL reverseDLL(ListNodeDLL head) {
        // if only 0 || 1 node is there
        if(head == null || head.next == null) {
            return head;
        }
        // to store the DLL values
        Stack<Integer> stack = new Stack<>();
        // traverse and store DLL values in stack
        ListNodeDLL temp = head;
        while(temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        // now we create a DLL with stack values
        ListNodeDLL newHead = new ListNodeDLL(stack.pop());
        temp =  newHead;
        while(!stack.isEmpty()) {
            ListNodeDLL nn = new ListNodeDLL(stack.pop());
            temp.next = nn;
            nn.prev = temp;
            temp = nn;
        }

        return newHead;
    }

    public static ListNodeDLL arrayToDll(int[] nums) {
        ListNodeDLL head = new ListNodeDLL(nums[0]);
        ListNodeDLL temp = head;
        for (int i=1; i<nums.length; i++) {
            ListNodeDLL nn = new ListNodeDLL(nums[i]);
            temp.next = nn;
            nn.prev = temp;
            temp = nn;
        }
        return head;
    }

    public static void print(ListNodeDLL head) {
        ListNodeDLL temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
