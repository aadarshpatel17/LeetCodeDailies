package org.practise.striver.dsasheet.linkedlist.medium;

import org.practise.striver.dsasheet.linkedlist.ListNode;

import static org.practise.striver.dsasheet.linkedlist.PractiseI.print;
import static org.practise.striver.dsasheet.linkedlist.medium.LC_206.arrayToLL;

public class LC_19 {

    // 19. Remove Nth Node From End of List

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = arrayToLL(nums);
        head = removeNthFromEnd(head, 2);
        print(head);
    }

    public static ListNode removeNthFromEnd_optimize(ListNode head, int n) {
        // Create a dummy node before head to handle edge cases
        ListNode dummy = new ListNode(0, head);

        // Initialize slow and fast at dummy
        ListNode slow = dummy;
        ListNode fast = dummy;

        // move fast pointer n+1 steps ahead to create a gap
        for(int i=0; i<=n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Slow is now at node before target → delete target node
        slow.next = slow.next.next;

        // Return updated head
        return dummy.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1))
            return null;

        // find the length of the LL
        int len = lengthOfLL(head);
        int count = len - n;
        if (count == 0) {
            return head.next;
        }
        ListNode temp = head;
        while (temp != null) {
            count--;
            if (count == 0) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static int lengthOfLL(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }


}
