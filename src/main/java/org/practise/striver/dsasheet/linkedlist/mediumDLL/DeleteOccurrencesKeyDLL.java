package org.practise.striver.dsasheet.linkedlist.mediumDLL;

import org.practise.striver.dsasheet.linkedlist.ListNodeDLL;

import static org.practise.striver.dsasheet.linkedlist.DLL.RerveseDLL.arrayToDll;
import static org.practise.striver.dsasheet.linkedlist.DLL.RerveseDLL.print;

public class DeleteOccurrencesKeyDLL {

    /*
        Delete all occurrences of a key in DLL
        URL: https://takeuforward.org/plus/dsa/problems/delete-all-occurrences-of-a-key-in-dll?source=strivers-a2z-dsa-track
    */

    public static void main(String[] args) {
        int[] nums = {10, 4, 10, 10, 6, 10};
        ListNodeDLL head = arrayToDll(nums);

        head = deleteAllOccurrences(head, 10);

        print(head);
    }

    public static ListNodeDLL deleteAllOccurrences(ListNodeDLL head, int key) {
        ListNodeDLL temp = head;
        while(temp != null) {
            if(temp.val == key) {
                if(temp == head) {
                    head = head.next;
                }
                ListNodeDLL nextNode = temp.next;
                ListNodeDLL prevNode = temp.prev;
                if(nextNode != null) {
                    nextNode.prev = prevNode;
                }
                if(prevNode != null) {
                    prevNode.next = nextNode;
                }
                temp = nextNode;
            } else {
                temp = temp.next;
            }

        }
        return head;
    }

}
