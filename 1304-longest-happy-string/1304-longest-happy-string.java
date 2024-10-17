class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int[] arr = new int[]{a,b,c};
        int count = a+b+c, last = -1, lastCount = count;
        String ans = "";
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->Integer.compare(y[0], x[0]));
        if(a>0) pq.add(new int[]{a,0});
        if(b>0) pq.add(new int[]{b,1});
        if(c>0) pq.add(new int[]{c,2});
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            char ch = (char)(top[1]+'a');
            int n = ans.length();
            if(n >= 2 && ans.charAt(n-1) == ans.charAt(n-2) && ans.charAt(n-1) == ch) {
                if(pq.isEmpty()) break;
                int[] second = pq.poll();
                ans += (char)(second[1] + 'a');
                second[0]--;
                if(second[0] > 0) pq.add(second);
            } else {
                ans += ch;
                top[0]--;
            }
            if(top[0] > 0) pq.add(top);
        }
        return ans;
    }
}