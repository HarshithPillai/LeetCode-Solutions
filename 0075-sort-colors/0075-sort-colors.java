class Solution {
    public void sortColors(int[] nums) {
        int i=0, j=0, k=0;
        for(int a=0; a<nums.length; a++) {
            if(nums[a]==0) i++;
            else if(nums[a]==1) j++;
        }
        for(int a=0; a<nums.length; a++) {
            if(i==0 && j==0) nums[a]=2;
            else if(i==0) {nums[a]=1; j--;}
            else {nums[a]=0; i--;}
        }
    }
}