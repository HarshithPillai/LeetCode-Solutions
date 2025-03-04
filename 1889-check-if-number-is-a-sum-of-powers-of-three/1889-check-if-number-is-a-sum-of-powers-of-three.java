class Solution {
    public boolean helper(double n, int exp) {
        if (n == 0) return true;
        if (n < 0 || n < Math.pow(3, exp)) return false;
        return helper(n - Math.pow(3, exp), exp + 1) || helper(n, exp + 1);
    }
    public boolean checkPowersOfThree(int n) {
        return helper((double) n, 0);
    }
}