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
        if(head==null) return null;
        Node prev= new Node(-1);
        Node result = prev;
        
        Node curr=head;
        
        while(curr!=null) {
            Node newNode = new Node(curr.val);
            newNode.next=curr.next;
            curr.next=newNode;
            curr=curr.next.next;
        }

        curr=head;
        while(curr!=null) {
            if(curr.random==null) curr.next.random=null;
            else curr.next.random=curr.random.next;
            curr = curr.next.next;
        }
        curr=head.next;
        result.next = curr;
        prev=head;
        while(curr!=null) {
            prev.next=curr.next;
            if(curr.next!=null)curr.next=curr.next.next;
            if(curr!=null) {
                curr=curr.next;
                prev=prev.next;
            }
            else break;
        }

        return result.next;
    }
}