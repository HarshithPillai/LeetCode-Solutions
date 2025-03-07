class Solution {
    public int[] closestPrimes(int left, int right) {
        /**
            sieve of eratosthenes
        */
        boolean[] sieve = new boolean[right+1];
        Arrays.fill(sieve, true);

        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i <= right; i++) {
            if (sieve[i] == false) continue;
            for (int j = 2; (j * i) <= right; j++) {
                sieve[j * i] = false;
            }
        }

        int[] ans = new int[]{-1, -1};
        int last = -1;
        for (int i = left; i<=right; i++) {
            if (sieve[i] == false) continue;
            if (ans[0] == -1) {
                ans[0] = i;
            } else if (ans[1] == -1) {
                ans[1] = i;
            } else {
                if (ans[1] - ans[0] > i - last) {
                    ans[0] = last;
                    ans[1] = i;
                }
            }
            last = i;
        }

        if (ans[0] == -1 || ans[1] == -1) return new int[]{-1, -1};

        return ans;
    }
}