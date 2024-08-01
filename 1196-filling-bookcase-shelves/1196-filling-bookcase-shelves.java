class Solution {
    /**
        currHeight==0 then place
        if width of the book is within limits:
            if height is within <= currHeight: place
            else either place or go to the next shelf
        else go to the next shelf
    */
    int sw, n;
    Integer[] dp;
    public int helper(int[][] books, int ind) {
        if(ind == n) return 0;
        int currw = sw-books[ind][0], currh = books[ind][1], res = (int)1e7;
        if(ind == n-1) return currh;
        if(dp[ind] != null) return dp[ind];
        for(int i=ind+1; i<n; i++) {
            int w = books[i][0], h = books[i][1];
            if(currw >= w) {
                int dont = currh + helper(books, i);
                currh = Math.max(currh, h);
                int take = currh + helper(books, i+1);
                currw-=w;
                res = Math.min(res, Math.min(take, dont));
            } else {
                res = Math.min(res, currh + helper(books, i));
                break;
            }
        }
        return dp[ind] = res;
    }
    public int minHeightShelves(int[][] books, int shelfWidth) {
        sw = shelfWidth;
        n = books.length;
        dp = new Integer[n];
        return helper(books, 0);
    }
}