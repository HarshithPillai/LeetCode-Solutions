class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    Set<Integer> set;
    int pointer;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        pointer = 1;
    }
    
    public int popSmallest() {
        if(pq.isEmpty()) {
            pointer++;
            return pointer-1;
        } else {
            set.remove(pq.peek());
            return pq.poll();
        }
    }
    
    public void addBack(int num) {
        if(num < pointer) {
            if(!set.contains(num)) {
                set.add(num);
                pq.add(num);
            }
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */