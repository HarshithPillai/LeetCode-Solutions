class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length, i=0, j=1, k=n-1;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(; i<n-2; i++) {
            while(i>0 && nums[i] == nums[i-1]) i++;
            j=i+1;
            k=n-1;
            while(j<k) {
                int sum = nums[j] + nums[k] + nums[i];
                if(sum == 0) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++; k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
                while(j<k-1 && j-1>i && nums[j] == nums[j-1]) j++;
                while(j<k-1 && k<n-1 && nums[k] == nums[k+1]) k--;
            }
        }
        return res;
    }
}