class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->Integer.compare(a,b));
    int cap;
    public KthLargest(int k, int[] nums) {
        cap = k;
        for(int num:nums) {
            pq.add(num);
            while(pq.size() > cap) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size() > cap) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */