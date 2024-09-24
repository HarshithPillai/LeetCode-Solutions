class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));
        int currDay = 0, count = 0, n = events.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(a,b));
        int i=0;
        while(i<n || !pq.isEmpty()) {
            if(pq.isEmpty()) {
                currDay = events[i][0];
            }
            while(i<n && currDay >= events[i][0]) {
                pq.add(events[i][1]);
                i++;
            }
            pq.poll();
            count++;
            currDay++;
            while(!pq.isEmpty() && pq.peek() < currDay) pq.poll();
        }
        return count;
    }
}