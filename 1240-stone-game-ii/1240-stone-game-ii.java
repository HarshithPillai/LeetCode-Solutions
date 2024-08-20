class Solution {
    int n;
    Integer dp[][][];
    public int helper(int[] piles, int isAlice, int ind, int M) {
        if(ind >= n) return 0;
        if(dp[isAlice][ind][M] != null) return dp[isAlice][ind][M];
        int res = 0;
        if(isAlice == 0) res = (int)1e9;
        int total = 0;
        for(int X = 0; X < 2*M; X++) {
            if(ind + X >= n) break;
            total += piles[ind + X];
            if(isAlice == 1) {
                res = Math.max(res, total + helper(piles, 0, ind + X + 1, Math.max(X+1, M)));
            } else {
                res = Math.min(res, helper(piles, 1, ind + X + 1, Math.max(X+1, M)));
            }
        }
        return dp[isAlice][ind][M] = res;
    }
    public int stoneGameII(int[] piles) {
        /**
            recursive function to return JUST alice's score
            helper(boolean alice, int ind, int M) 
            alice - boolean to denote whether the turn is of Alice or Bob
            ind - index
            M - we can chose X amounts of stones where 1 <= X <= 2*M

            for alice's case, we take return the total score of alice if alice picks up X amounts of piles
                here we need Alice to have the maximum score Alice can get out of all choices
            for bob's case, we let him pick up whatever amount of stones and return Alice's score
                here we need Alice to get the MINIMUM SCORE that alice can get after BOB picks up X amounts of stones

            BOTH NEED TO PLAY OPTIMALLY
        */
        n = piles.length;
        dp = new Integer[2][n+1][n+1];
        return helper(piles, 1, 0, 1);
    }
}