class Solution {

    public  void recPer(int[] nums, List<List<Integer>> ans, int ind) {
        int size = nums.length;
        if(ind==size-1) {
            List<Integer> curr = new ArrayList<Integer>();
            for(int i=0; i<size; i++) {
                curr.add(nums[i]);
            }
            ans.add(curr);
            return;
        }
        for(int i=ind; i<size; i++) {
            int a=nums[ind];
            nums[ind]=nums[i];
            nums[i]=a;
            
            recPer(nums, ans, ind+1);

            a=nums[ind];
            nums[ind]=nums[i];
            nums[i]=a;
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        recPer(nums, ans, 0);

        return ans;
        
    }
}