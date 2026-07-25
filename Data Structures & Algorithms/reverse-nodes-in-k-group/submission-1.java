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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode prevGroupTail = dummy, curr = head;
        while(count >= k) {
            ListNode prev = null;
            temp = curr;

            for(int i=0; i<k; i++) {
                ListNode next = temp.next;
                temp.next = prev;
                prev = temp;
                temp = next;
            }

            prevGroupTail.next = prev;
            curr.next = temp;
            prevGroupTail = curr;
            curr = temp;
            count -= k;
        }

        return dummy.next;
    }
}
