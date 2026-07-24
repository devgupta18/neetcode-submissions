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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for(int i=0; i<lists.length; i++) {
            if(ans == null) {
                ans = mergeTwoLists(lists[i], lists[i+1]);
                i++;
            } else {
                ans = mergeTwoLists(ans, lists[i]);
            }
        }

        return ans;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        while(l1 != null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }

        while(l2 != null) {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}