class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] interval:intervals) {
            int s = interval[0], e = interval[1];
            while(!pq.isEmpty() && pq.peek() < s) {
                pq.poll();
            }
            pq.add(e);
            max = Math.max(max, pq.size());
        }
        return max;
    }
}