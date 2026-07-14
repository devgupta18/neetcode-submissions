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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode dummy = null, temp = slow.next;
        slow.next = null;
        while(temp != null) {
            ListNode front = temp.next;
            temp.next = dummy;
            dummy = temp;
            temp = front;
        }

        slow = head;
        boolean flag = true;
        while(slow != null && dummy != null) {
            if(flag) {
                ListNode d = slow.next;
                slow.next = dummy;
                slow = d;
            } else {
                ListNode d = dummy.next;
                dummy.next = slow;
                dummy = d;
            }
            flag = !flag;
        }
    }
}
