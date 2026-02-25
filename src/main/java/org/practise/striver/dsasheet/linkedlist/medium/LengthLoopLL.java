package org.practise.striver.dsasheet.linkedlist.medium;

import org.practise.striver.dsasheet.linkedlist.Node;

public class LengthLoopLL {

    public int findLengthOfLoop_optimized(Node head) {
        if (head == null)
            return 0;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return countLoopLength(slow);
            }
        }
        return 0;
    }

    public int findLengthOfLoop(Node head) {
        if (head == null)
            return 0;

        Node slow = head;
        Node fast = head;

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

    public int countLoopLength(Node meetingPoint) {
        int length = 1;
        Node temp = meetingPoint;
        while (temp.next != meetingPoint) {
            temp = temp.next;
            length += 1;
        }
        return length;
    }
}
