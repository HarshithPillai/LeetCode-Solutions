class Solution {
    public void nextPermutation(int[] nums) {
        // find the first instance of sorted pair and switch them ind1<->ind2
        // then sort (ind1+1,end of array)

        int size=nums.length;

        if(size<2) return;

        boolean swappedFlag = false;

        int ind1=-1;

        for(int i=size-2; i>=0; i--) {
            if(nums[i]<nums[i+1]) {
                ind1=i;
                break;
            }
        }
        if(ind1>-1) {
            int a=nums[ind1];
            int min = -1;
            int minVal = Integer.MAX_VALUE;
            for(int i=ind1+1; i<size; i++) {
                if(nums[ind1]<nums[i] && nums[i]<minVal) {
                    min=i; minVal=nums[i];
                }
            }
            // found the min value after the peak that is also greater than nums[ind1]
            a=nums[ind1];
            nums[ind1]=nums[min];
            nums[min]=a;
            
            Arrays.sort(nums, ind1+1, nums.length);

        } else {
            Arrays.sort(nums);
        }
    }
}