class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(), pq2 = new PriorityQueue<>();
        int l=0, n=costs.length, r = n-1;
        for(int i=0; i<candidates; i++) {
            if(l==r) pq1.add(costs[l]);
            else if(l<r) {
                pq1.add(costs[l]);
                pq2.add(costs[r]);
            }
            l++; r--;
        }
        long ans=0;
        while(k>0) {
            // System.out.println(pq1.peek() + " " + pq2.peek());
            if(!pq1.isEmpty() && !pq2.isEmpty()) {
                if(pq1.peek() <= pq2.peek()) {
                    ans += pq1.poll();
                    if(l<=r) pq1.add(costs[l]);
                    l++;
                } else {
                    ans += pq2.poll();
                    if(r>=l) pq2.add(costs[r]);
                    r--;
                }
            } else if(!pq1.isEmpty()) {
                ans += pq1.poll();
                if(l<=r) pq1.add(costs[l]);
                l++;
            } else {
                ans += pq2.poll();
                if(r>=l) pq2.add(costs[r]);
                r--;
            }
            k--;
        }
        return ans;
    }
}