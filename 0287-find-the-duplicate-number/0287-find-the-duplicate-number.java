class Solution {
    public int findDuplicate(int[] nums) {
        int size=nums.length; 
        int meet=-1;
        if(size<3) return nums[0];
        int slow=nums[0], fast=nums[nums[0]];
        while(true) {
            if(slow==fast) {
                meet=slow;
                slow=0;
                break;
            }
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        fast=meet;
        while(slow!=fast) {
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}