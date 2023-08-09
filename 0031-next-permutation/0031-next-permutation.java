class Solution {
    public void reverse(int[] nums, int ind) {
        int size=nums.length;
        if(ind>size-1) return;
        
        for(int i=ind; i<(ind+size)/2; i++) {
            if(i<size-i+ind-1 && nums[i]>nums[size-i+ind-1]) {
                int a=nums[i];
                nums[i]=nums[size-i+ind-1];
                nums[size-i+ind-1]=a;
                
                //ind=3
                //a=1
                //size-i+ind-1 = 4
                //i=3
                //nums[i]=3
            }
        }
    }

    public void nextPermutation(int[] nums) {
        int size=nums.length;
        if(size<2) return;
        int ind1=-1;

        for(int i=size-2; i>=0; i--) {
            if(nums[i]<nums[i+1]) {
                ind1=i;
                break;
            }
        }
        if(ind1>-1) {
            int min = -1, minVal = Integer.MAX_VALUE;
            
            for(int i=size-1; i>ind1; i--) {
                if(nums[ind1]<nums[i] && nums[i]<minVal) {
                    min=i; minVal=nums[i];
                }
            }
            
            int a=nums[ind1];
            nums[ind1]=nums[min];
            nums[min]=a;
            
            reverse(nums, ind1+1);

        } else {
            reverse(nums,0);
        }
    }
}