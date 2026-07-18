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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode prev = null, head = null;

        while(l1 != null && l2 != null) {
            int digit = l1.val + l2.val + carry;
            carry = digit / 10;
            digit %= 10;
            ListNode n = new ListNode(digit);
            if(prev != null) {
                prev.next = n;
            }
            if(head == null) head = n;
            prev = n;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int digit = l1.val + carry;
            carry = digit / 10;
            digit %= 10;
            ListNode n = new ListNode(digit);
            prev.next = n;
            prev = n;
            l1 = l1.next;
        }

        while(l2 != null) {
            int digit = l2.val + carry;
            carry = digit / 10;
            digit %= 10;
            ListNode n = new ListNode(digit);
            prev.next = n;
            prev = n;
            l2 = l2.next;
        }

        if(carry == 1) {
            ListNode n = new ListNode(carry);
            prev.next = n;
            prev = n;
        }

        return head;
        
    }
}
