class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int indg = g.length-1, inds = s.length-1;
        int ans = 0;
        while(indg>=0 && inds>=0) {
            while(indg>=0 && g[indg] > s[inds]) indg--;
            if(indg == -1) break;
            int greed = g[indg--];
            if(greed <= s[inds]) {
                ans++;
                inds--;
            }
        }
        return ans;
    }
}