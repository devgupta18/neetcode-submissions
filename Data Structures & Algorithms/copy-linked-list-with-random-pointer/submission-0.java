/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head, itr = head, fast = null;

        while(temp != null) {
            Node n = new Node(temp.val);
            n.next = temp.next;
            temp.next = n;
            temp = temp.next.next;
        }

        while(itr != null) {
            if(itr.random != null) {
                itr.next.random = itr.random.next;
            }
            itr = itr.next.next;
        }

        Node curr = new Node(0);
        itr = head;
        temp = curr;
        while(itr != null) {
            fast = itr.next.next;
            temp.next = itr.next;
            itr.next = fast;
            temp = temp.next;
            itr = fast;
        }        
        
        return curr.next;
    }
}
