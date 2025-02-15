class Solution {
    public boolean helper(int val, int exp, int i) {
        if(i == 0 && val == 0) return true;
        if(exp > val) return val == i;
        if(i <= 0 || val == 0) return false;
        exp *= 10;
        return helper(val, exp, i) || helper(val/exp, 1, i-(val%exp));
    }
    public int punishmentNumber(int n) {
        /**
            positive integer n
            i -> [1, n]
        */
        int ans = 0;
        for(int i=1; i<=n; i++) {
            boolean punishment = helper(i * i, 1, i);
            if(punishment) ans += i*i;
        }
        return ans;
    }
}