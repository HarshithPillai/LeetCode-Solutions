class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1l);
        Set<Long> set = new HashSet<>();
        set.add(1l);
        while(!pq.isEmpty()) {
            long top = pq.poll();
            n--;
            if(n==0) return (int)top;
            if(!set.contains(top*2)) {
                set.add(top*2);
                pq.add(top*2);
            }
            if(!set.contains(top*3)) {
                set.add(top*3);
                pq.add(top*3);
            }
            if(!set.contains(top*5)) {
                set.add(top*5);
                pq.add(top*5);
            }
        }
        return -1;
    }
}