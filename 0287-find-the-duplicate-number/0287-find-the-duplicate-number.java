class Solution {
    public int findDuplicate(int[] nums) {
        int size=nums.length;
        if(size<3) return nums[0];
        int slow=nums[0], fast=nums[nums[0]];
        while(true) {
            if(slow==fast) {
                slow=0;
                break;
            }
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        while(slow!=fast) {
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}