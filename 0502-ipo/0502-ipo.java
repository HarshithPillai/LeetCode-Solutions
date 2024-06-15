class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a[1], b[1]);
        });
        for(int i=0; i<profits.length; i++) pq.add(new int[]{profits[i], capital[i]});
        PriorityQueue<int[]> profitQueue = new PriorityQueue<>((a,b)->Integer.compare(b[0], a[0]));
        
        while(!pq.isEmpty() && k>0) {
            while(!pq.isEmpty() && pq.peek()[1] <= w) profitQueue.add(pq.poll());
            if(profitQueue.isEmpty())  break;
            w += profitQueue.peek()[0];
            profitQueue.poll();
            k--;
        }
        while(k>0 && !profitQueue.isEmpty()) {
            w+=profitQueue.peek()[0];
            profitQueue.poll();
            k--;
        }

        return w;
    }
}