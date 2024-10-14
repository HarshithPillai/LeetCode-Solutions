class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        long score = 0;
        for(int i:nums) pq.add(i);
        while(k>0) {
            int val = pq.poll();
            score += val;
            pq.add((val+2)/3);
            k--;
        }
        return score;
    }
}