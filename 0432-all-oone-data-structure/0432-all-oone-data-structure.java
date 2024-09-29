class AllOne {

    class Node {
        int freq;
        Set<String> set;
        Node prev, next;
        Node(int freq, Node prev, Node next) {
            this.freq = freq;
            this.prev = prev;
            this.next = next;
            set = new HashSet<>();
        }
    }

    Node head, tail;
    Map<String, Node> map;

    public AllOne() {
        map = new HashMap<>();
        head = new Node(-100, null, null);
        tail = new Node((int)1e9, null, null);
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        if(map.containsKey(key)) {
            // get node from map for the given string
            Node curr = map.get(key);
            curr.set.remove(key);
            int freq = curr.freq;
            if(curr.set.isEmpty()) {
                Node previous = curr.prev;
                Node nextOne = curr.next;
                nextOne.prev = previous;
                previous.next = nextOne;
                curr = previous;
            }
            // if next node does not have the intended count then create a new one
            if(curr.next.freq != freq+1) {
                Node newNode = new Node(freq+1, curr, curr.next);
                curr.next.prev = newNode;
                curr.next = newNode;
                newNode.set.add(key);
                map.put(key, newNode);
            } else {
                // next node has the intended freq
                Node next = curr.next;
                next.set.add(key);
                map.put(key, next);
            }
        } else {
            Node newNode = new Node(1, head, head.next);
            if(head.next.freq == 1) {
                map.put(key, head.next);
                head.next.set.add(key);
            } else {
                head.next.prev = newNode;
                head.next = newNode;
                map.put(key, newNode);
                newNode.set.add(key);
            }
        }
        Node curr = head.next;
        // while(curr.next != null) {
        //     for(String s:curr.set) System.out.print(s+" ");
        //     System.out.print(curr.freq+"\n ------- \n");
        //     curr = curr.next;
        // }
        // System.out.println("--------------------------------------");
    }
    
    public void dec(String key) {
        Node curr = map.get(key);
        curr.set.remove(key);
        map.remove(key);
        int freq = curr.freq;
        if(curr.set.isEmpty()) {
            System.out.println("node empty "+freq+" "+key);
            Node previous = curr.prev;
            Node nextOne = curr.next;
            nextOne.prev = previous;
            previous.next = nextOne;
            curr = nextOne;
        }
        if(freq == 1) {
            // curr = head.next;
            // while(curr.next != null) {
            //     for(String s:curr.set) System.out.print(s+" ");
            //     System.out.print(curr.freq+"\n ------- \n");
            //     curr = curr.next;
            // }
            // System.out.println("------------------freq 1 --------------------");
            return;
        }
        if(curr.prev.freq != freq - 1) {
            // intended freq node does not exist
            Node newNode = new Node(freq - 1, curr.prev, curr);
            curr.prev.next = newNode;
            curr.prev = newNode;
            newNode.set.add(key);
            map.put(key, newNode);
        } else {
            // intended freq node exists
            curr.prev.set.add(key);
            map.put(key, curr.prev);
        }
        // curr = head.next;
        // while(curr.next != null) {
        //     for(String s:curr.set) System.out.print(s+" ");
        //     System.out.print(curr.freq+"\n ------- \n");
        //     curr = curr.next;
        // }
        // System.out.println("--------------------------------------");
    }
    
    public String getMaxKey() {
        Node curr = tail.prev;
        if(curr == head) return "";
        for(String s:curr.set) return s;
        return "";
    }
    
    public String getMinKey() {
        Node curr = head.next;
        if(curr == tail) return "";
        for(String s:curr.set) return s;
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */