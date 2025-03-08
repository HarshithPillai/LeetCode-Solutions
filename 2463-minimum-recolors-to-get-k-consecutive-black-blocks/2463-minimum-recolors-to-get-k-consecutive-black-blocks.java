class Solution {
    public int minimumRecolors(String blocks, int k) {
        /**
            minimum recolors to get k consecutive black blocks
            - 0-indexed string blocks of length n
            - blocks[i] is either 'W' or 'B'
            - integer k, which is desired number of consecutive black blocks
            - one operation conver white block to black block
            - return the minimum number of opreations needed such that there is at least 
                one occurrence of k consecutive black blocks
        */

        int l = 0, r = 0, count = 0, n = blocks.length(), ans = k;
        char[] arr = blocks.toCharArray();
        while (r < n) {
            if (arr[r] == 'W') count++;
            if (r - l + 1 > k) {
                if (arr[l] == 'W') {
                    count--;
                }
                l++;
            }

            if (r - l + 1 == k) ans = Math.min(ans, count);
            r++;
        }
        return ans;
    }
}