class MyCalendar {

    class Node {
        int s, e;
        Node left, right;
        Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    Node root;

    public MyCalendar() {
        
    }

    public boolean insert(Node newNode, Node node) {
        if(newNode.e > node.s && newNode.s < node.e) return false;
        if(newNode.e <= node.s) {
            if(node.left == null) {
                node.left = newNode;
                return true;
            } else {
                return insert(newNode, node.left);
            }
        } else {
            if(node.right == null) {
                node.right = newNode;
                return true;
            } else {
                return insert(newNode, node.right);
            }
        }
    }
    
    public boolean book(int start, int end) {
        Node newNode = new Node(start, end);
        if(root == null) {
            root = newNode;
            return true;
        }
        return insert(newNode, root);
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */