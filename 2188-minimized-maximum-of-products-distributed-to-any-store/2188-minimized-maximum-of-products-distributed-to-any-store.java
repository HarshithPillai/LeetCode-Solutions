class Solution {
    public boolean check(int mid, int n, int[] quantities) {
        int count = 0;
        for(int i:quantities) {
            count += i/mid;
            if(i%mid > 0) count++;
        }
        return count <= n;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1, r = 1, m = quantities.length;
        for(int i:quantities) r = Math.max(r, i);
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(check(mid, n, quantities)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}