class Solution {
    public int findContentChildren(int[] g, int[] s) {
        PriorityQueue<Integer> gp = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        PriorityQueue<Integer> sp = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i:g) gp.add(i);
        for(int i:s) sp.add(i);
        int ans = 0;
        while(!gp.isEmpty() && !sp.isEmpty()) {
            while(!gp.isEmpty() && gp.peek() > sp.peek()) gp.poll();
            if(gp.isEmpty()) break;
            int greed = gp.poll();
            if(greed <= sp.peek()) {
                ans++;
                sp.poll();
            }
        }
        return ans;
    }
}