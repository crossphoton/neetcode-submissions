/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode currList1 = list1, currList2 = list2;
        ListNode currNode = currList1.val < currList2.val ? currList1: currList2;
        if (currNode == currList1) {
            currList1 = currList1.next;
        } else {
            currList2 = currList2.next;
        }

        ListNode firstNode = currNode;

        while (currList1 != null && currList2 != null) {
            if (currList1.val > currList2.val) {
                currNode.next = currList2;
                currList2 = currList2.next;
            } else {
                currNode.next = currList1;
                currList1 = currList1.next;
            }

            currNode = currNode.next;
        }

        while (currList1 != null) {
            currNode.next = currList1;
            currList1 = currList1.next;

            currNode = currNode.next;
        }

        while (currList2 != null) {
            currNode.next = currList2;
            currList2 = currList2.next;

            currNode = currNode.next;
        }

        return firstNode;        
    }
}