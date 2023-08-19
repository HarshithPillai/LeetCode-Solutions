class Solution {
    public void swap(int[] nums, int low, int high) {
        int a=nums[low];
        nums[low] = nums[high];
        nums[high]=a;
    }
    public void sortColors(int[] nums) {
        //int i=0, j=0, k=0;
        // for(int a=0; a<nums.length; a++) {
        //     if(nums[a]==0) i++;
        //     else if(nums[a]==1) j++;
        // }
        // for(int a=0; a<nums.length; a++) {
        //     if(i==0 && j==0) nums[a]=2;
        //     else if(i==0) {nums[a]=1; j--;}
        //     else {nums[a]=0; i--;}
        // }
        int n=nums.length;
        if(n==1) return;


        int low=0, mid=0, high=n-1;
        while(mid<=high) {
            if(nums[mid]==0) {
                swap(nums, mid, low);
                mid++;
                low++;
            } else if(nums[mid]==1) {
                mid++;
            } else {
                swap(nums, high, mid);
                high--;
            }
        }
    }
}