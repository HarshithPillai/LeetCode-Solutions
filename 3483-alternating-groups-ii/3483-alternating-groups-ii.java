class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        /**
            array of integers 'colors', and an integer 'k'
            color of tile 'i' is represented by colors[i]
            colors[i] == 0 means that tile i is red
            colors[i] == 1 means that tile i is blue
            0 - red
            1 - blue
        */

        int n = colors.length, ans = 0, last = -1, curr = 0;
        for (int r = 0; r < n - 1 + k; r++) {
            int ind = r % n;
            if (last != colors[ind]) {
                curr++;
            } else {
                curr = 1;
            }
            if (r >= k-1) {
                if (curr >= k) {
                    ans++;
                }
            }
            last = colors[ind];
        }

        return ans;
    }
}