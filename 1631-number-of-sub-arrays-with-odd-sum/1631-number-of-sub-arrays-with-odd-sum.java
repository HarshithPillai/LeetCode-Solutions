class Solution {
    long MOD = (long)1e9 + 7;
    public int numOfSubarrays(int[] arr) {
        int countOdd = 0, countEven = 1, curr = 0;
        long ans = 0;
        for(int i=0; i<arr.length; i++) {
            curr += arr[i];
            
            if (curr % 2 == 0) {
                ans = (ans + countOdd) % MOD;
                countEven++;
            } else {
                ans = (ans + countEven) % MOD;
                countOdd++;
            }

        }

        return (int) ans;
    }
}