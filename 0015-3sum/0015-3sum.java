class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i=0;i<n;i++) {
            while(i>0 && i<n-2 && nums[i]==nums[i-1]) i++;
            int j=i+1;
            int k=n-1;
            while(j<k) {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    k--;j++;
                } else if(sum<0) j++;
                else k--;
                
                while(j>i+1 && j<n && nums[j]==nums[j-1]) j++;
                while(k>0 && k<n-1 && nums[k]==nums[k+1]) k--;
            }
        }

        return result;
    }
}