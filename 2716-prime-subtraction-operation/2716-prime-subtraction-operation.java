class Solution {
    public boolean primeSubOperation(int[] nums) {
        boolean[] sieve = new boolean[1001];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;
        for(int i=2; i<1001; i++) {
            for(int j = 2; ; j++) {
                int ind = i*j;
                if(ind >= 1001) break;
                sieve[ind] = false;
            }
        }
        int n = nums.length;
        for(int i=n-2; i>=0; i--) {
            if(nums[i] >= nums[i+1]) {
                boolean found = false;
                for(int j=2; j<nums[i]; j++) {
                    if(sieve[j]) {
                        if(nums[i] - j < nums[i+1]) {
                            found = true;
                            nums[i]-=j;
                            break;
                        }
                    }
                }
                if(!found) return false;
            }
        }
        return true;
    }
}