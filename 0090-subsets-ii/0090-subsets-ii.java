class Solution {
    public void recUtil(Set<List<Integer>> set, int[] nums, List<Integer> list, int ind) {
        if(ind>=nums.length) {
            Collections.sort(list);
            set.add(new ArrayList<>(list));
            return;
        }

        recUtil(set, nums, new ArrayList<>(list), ind+1);
        list.add(nums[ind]);
        recUtil(set, nums, new ArrayList<>(list), ind+1);
        list.remove(list.size()-1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        recUtil(set, nums, new ArrayList<>(), 0);

        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> temp:set) {
            result.add(temp);
        }
        return result;
    }
}