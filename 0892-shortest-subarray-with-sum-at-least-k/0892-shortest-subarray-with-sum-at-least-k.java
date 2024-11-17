class Solution {
    class Pair {
        long sum;
        int ind;
        Pair(long sum, int ind) {
            this.sum = sum;
            this.ind = ind;
        }
    }
    public int shortestSubarray(int[] nums, int k) {
        // prefix sum rakh
        int n = nums.length, ans = n+1;
        long sum = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.sum, b.sum));
        pq.add(new Pair(sum, -1));
        for(int i=0; i<n; i++) {
            sum += nums[i];
            while(!pq.isEmpty() && (sum - pq.peek().sum) >= k) {
                ans = Math.min(ans, i - pq.poll().ind);
            }
            pq.add(new Pair(sum, i));
        }
        if(ans == n+1) return -1;
        return ans;
    }
}