class LRUCache {
    class dllNode{
        int val, key;
        dllNode prev;
        dllNode next;
        dllNode(int key, int val) {
            this.key=key; this.val=val; prev=null; next=null;
        }
    }

    dllNode head=new dllNode(-1, -1);
    dllNode tail=new dllNode(-1, -1);
    int capacity;
    
    Map<Integer, dllNode> map=new HashMap<>();

    public LRUCache(int capacity) {
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        dllNode curr = map.get(key);
        remove(curr);
        insert(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            dllNode temp = map.get(key);
            remove(temp);
        } else if(map.size()==capacity) {
            remove(tail.prev);
        }
        dllNode curr = new dllNode(key, value);
        curr.val=value;
        insert(curr);
    }

    public void remove(dllNode curr) {
        map.remove(curr.key);
        curr.prev.next=curr.next;
        curr.next.prev=curr.prev;
    }
    
    public void insert(dllNode curr) {
        map.put(curr.key, curr);
        head.next.prev=curr;
        curr.next=head.next;
        head.next=curr;
        curr.prev=head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */