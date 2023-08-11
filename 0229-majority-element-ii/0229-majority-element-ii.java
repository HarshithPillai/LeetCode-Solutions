class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int n=nums.length;

        

        int el1=Integer.MIN_VALUE, el2=Integer.MIN_VALUE, count1=0, count2=0;
        for(int i=0; i<n; i++) {
            if(count1==0 && nums[i]!=el2) {
                count1=1; el1=nums[i];
            } else if(count2==0 && nums[i]!=el1) {
                count2=1; el2=nums[i];
            } else if(nums[i]==el1 && nums[i]!=el2) {
                count1++;
            } else if(nums[i]==el2 && nums[i]!=el1) {
                count2++;
            } else {
                count1--; count2--;
            }
        }
        count1=0; count2=0;
        for(int i:nums) {
            if(i==el1) count1++;
            else if(i==el2) count2++;
        }
        if(count1>n/3) res.add(el1);
        if(count2>n/3) res.add(el2);
        return res;

    }
}