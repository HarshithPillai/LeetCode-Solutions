class KthLargest {
    PriorityQueue<Integer> pq;
    int cap;

    public KthLargest(int k, int[] nums) {
        cap=k; pq=new PriorityQueue<>();
        for(int n:nums) {
            if(pq.size()<cap) pq.add(n);
            else {
                if(pq.peek()<n) {
                    pq.poll();
                    pq.add(n);
                }
            }
        }
    }
    
    public int add(int n) {
        if(pq.size()<cap) pq.add(n);
        else {
            if(pq.peek()<n) {
                pq.poll();
                pq.add(n);
            }
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */