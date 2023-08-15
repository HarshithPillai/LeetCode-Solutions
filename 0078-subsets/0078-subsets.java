class Solution {

    public void recUtil(List<List<Integer>> result, List<Integer> newList, int[] nums, int ind) {
        if(ind>=nums.length) {
            result.add(new ArrayList<>(newList));
            return;
        }
        
        recUtil(result, newList, nums, ind+1);
        newList.add(nums[ind]);
        recUtil(result, newList, nums, ind+1);
        newList.remove(newList.size()-1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        //result.add(new ArrayList<>());
        recUtil(result, list, nums, 0);
        return result;
    }
}