class LFUCache {
    class dllNode {
        int key;
        int val;
        int freq=1;
        dllNode prev, next;
        dllNode(int k, int v) {
            key=k; val=v;
        }
    }
    // LRU
    class DoublyLinkedList {
        dllNode head, tail;
        int size=0;
        public DoublyLinkedList() {
            head=new dllNode(-1,-1);
            tail=new dllNode(-1,-1);
            head.next=tail;
            tail.prev=head;
        }
        // void put(int key, int value) {
        //     dllNode curr = new dllNode(key, value);
        //     if(nodeMap.containsKey(key)) {
        //         remove(nodeMap.get(key));
        //     }
        //     insert(curr);
        // }
        // int get(int key) {
        //     dllNode curr=nodeMap.get(key);
        //     remove(curr);
        //     insert(curr);
        //     return curr.val;
        // }
        void insert(dllNode curr) {
            curr.next=head.next;
            curr.prev=head;
            head.next.prev=curr;
            head.next=curr;
            size++;
        }
        void remove(dllNode curr) {
            curr.prev.next=curr.next;
            curr.next.prev=curr.prev;
            size--;
        }
    }
    //map to contains frequency and LRU Cache of that frequency
    Map<Integer, DoublyLinkedList> freqMap=new HashMap<>();
    Map<Integer, dllNode> nodeMap=new HashMap<>();
    int totalSize=0;
    int leastfreq=0;//
    int capacity;
    

    public LFUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)) return -1;
        dllNode curr=nodeMap.get(key);
        updateNode(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;

        dllNode curr = new dllNode(key, value);
        if(nodeMap.containsKey(key)) {
            curr=nodeMap.get(key);
            curr.val=value;
            updateNode(curr);
        } else {
            if(totalSize==capacity) {
                DoublyLinkedList LRU = freqMap.get(leastfreq);
                nodeMap.remove(LRU.tail.prev.key);
                LRU.remove(LRU.tail.prev);
                
                totalSize--;
            }
            leastfreq=1;
            DoublyLinkedList first = freqMap.getOrDefault(1, new DoublyLinkedList());
            first.insert(curr);
            freqMap.put(1, first);
            nodeMap.put(key, curr);
            totalSize++;
        }
    }

    public void updateNode(dllNode curr) {
        int fr=curr.freq;
        DoublyLinkedList LRU = freqMap.get(fr);
        LRU.remove(curr);
        
        if(fr==leastfreq && LRU.size==0) leastfreq++;
        curr.freq++;
        LRU = freqMap.getOrDefault(fr+1, new DoublyLinkedList());
        LRU.insert(curr);
        freqMap.put(fr+1, LRU);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */