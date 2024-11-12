class Solution {
    public int upperbound(int[][] items, int price) {
        // find the highest priced item, whose price is lesser than or equal to 'price'
        int l = 0, r = items.length-1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(items[mid][0] <= price) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        if(r>=0 && r<items.length) return items[r][1];
        return 0;
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a,b)->Integer.compare(a[0], b[0]));
        int maxB = -1, n = items.length, m = queries.length;
        for(int i=0; i<n; i++) {
            maxB = Math.max(items[i][1], maxB);
            items[i][1] = maxB;
        }

        int[] ans = new int[m];
        for(int i=0; i<m; i++) {
            if(queries[i] < items[0][0]) ans[i] = 0;
            else if(queries[i] > items[n-1][0]) ans[i] = items[n-1][1];
            else {
                ans[i] = upperbound(items, queries[i]);
            }
        }
        return ans;
    }
}