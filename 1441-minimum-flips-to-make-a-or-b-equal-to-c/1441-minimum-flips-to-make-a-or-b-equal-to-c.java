class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for(int i=30; i>=0 ; i--) {
            int mask = 1<<i;
            int val = (a & mask) + (b & mask);
            if((c & mask) != 0) {
                if(val == 0) ans++;
            } else {
                if((a & mask) != 0) ans++;
                if((b & mask) != 0) ans++;
            }
        }
        return ans;
    }
}