/*
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
*/

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
 
        while (temp != null && temp.next != null) {
 
            int k = temp.val;
            temp.val = temp.next.val;
            temp.next.val = k;
            temp = temp.next.next;
         }
        return head;
    }
}
