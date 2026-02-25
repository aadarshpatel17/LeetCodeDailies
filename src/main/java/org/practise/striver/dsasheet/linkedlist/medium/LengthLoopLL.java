package org.practise.striver.dsasheet.linkedlist.medium;

import org.practise.striver.dsasheet.linkedlist.ListNode;

public class LengthLoopLL {

    public int findLengthOfLoop_optimized(ListNode head) {
        if (head == null)
            return 0;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return countLoopLength(slow);
            }
        }
        return 0;
    }

    public int findLengthOfLoop(ListNode head) {
        if (head == null)
            return 0;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return countLoopLength(slow);
            }
        }

        return 0;
    }

    public int countLoopLength(ListNode meetingPoint) {
        int length = 1;
        ListNode temp = meetingPoint;
        while (temp.next != meetingPoint) {
            temp = temp.next;
            length += 1;
        }
        return length;
    }
}
