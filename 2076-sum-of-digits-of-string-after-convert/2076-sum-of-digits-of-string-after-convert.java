class Solution {
    public int getSum(int val) {
        int sum = 0;
        while(val>0) {
            sum += val%10;
            val/=10;
        }
        return sum;
    }
    public int getLucky(String s, int k) {
        char[] arr = s.toCharArray();
        int ans = 0;
        for(char ch:arr) {
            ans+=getSum(ch-'a'+1);
        }
        // ans = getSum(ans);
        while(--k>0) ans = getSum(ans);
        return ans;
    }
}