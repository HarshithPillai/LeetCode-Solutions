class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sumM = 0, m = rolls.length;
        for(int i:rolls) sumM+=i;
        // sum(n) = mean*(n+m) - sum(m)
        int sumN = mean*(n+m) - sumM;
        if(sumN < 0 || n*6 < sumN) return new int[0];
        List<Integer> res = new ArrayList<>();
        
        int[] ans = new int[n];
        // if((sumN + 1)/n > 6) return new int[0];
        // if(sumN < 0) return new int[0];

        for(int i=0; i<n; i++) {
            ans[i] = Math.min(6, sumN - (n-i-1));
            if(ans[i] <= 0) return new int[0];
            sumN-=ans[i];
        }
        if(sumN != 0) return new int[0];
        return ans; 
    }
}