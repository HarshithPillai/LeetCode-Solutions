class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr=0;
        int max=0;
        for(int i:nums) {
            if(i==1) {
                curr++;
                max=(max>curr)?max:curr;
            } else {
                curr=0;
            }
        }
        return max;
    }
}