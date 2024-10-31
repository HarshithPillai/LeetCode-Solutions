class Solution {
    int n, m;
    Long[][][] dp;
    public long helper(List<Integer> robot, int ind, int[][] factory, int find) {
        if(ind == n) return 0;
        if(find == m) return (long)1e18;
        if(dp[ind][find][factory[find][1]] != null) return dp[ind][find][factory[find][1]];
        long res = (long)1e18;
        // for(int i=0; i<m; i++) {
        //     if(factory[i][1] > 0) {
        //         factory[i][1]--;
        //         res = Math.min(res, Math.abs(robot.get(ind) - factory[i][0]) + helper(robot, ind+1, factory));
        //         factory[i][1]++;
        //     }
        // }
        if(factory[find][1] > 0) {
            factory[find][1]--;
            res = helper(robot, ind+1, factory, find) + Math.abs(robot.get(ind) - factory[find][0]);
            factory[find][1]++;
        }
        res = Math.min(res, helper(robot, ind, factory, find+1));
        return dp[ind][find][factory[find][1]] = res;
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a,b)->Integer.compare(a[0], b[0]));
        for(int i=0; i<m; i++) if(factory[i][1] > 100) factory[i][1] = 100;
        n = robot.size();
        m = factory.length;
        dp = new Long[n][m][101];
        return helper(robot, 0, factory, 0);
    }
}