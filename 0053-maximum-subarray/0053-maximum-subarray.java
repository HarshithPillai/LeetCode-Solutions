class Solution {
    public int maxSubArray(int[] nums) {
                
        //if(nums.length==1) return nums[0];
        int maxSum=Integer.MIN_VALUE, sum=0;
        for(int i=0; i<nums.length; i++) {
            //temp[i]=(nums[i]+temp[i-1]>0)?(nums[i]+temp[i-1]):0;
            
            sum+=nums[i];
            if(maxSum<sum) maxSum=sum;
            if(sum<0) sum=0;

        }
        return maxSum;
    }
}