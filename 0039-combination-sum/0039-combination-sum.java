class Solution {
    public void recUtil(List<List<Integer>> result, int[] candidates, List<Integer> list, int sum, int target, int ind) {
        if(sum>target || ind>=candidates.length) return;
        if(sum==target) {
            result.add(new ArrayList<>(list));
            return;
        }

        recUtil(result, candidates, list, sum, target, ind+1);
        list.add(candidates[ind]);
        recUtil(result, candidates, list, sum+candidates[ind], target, ind);
        list.remove(list.size()-1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        recUtil(result, candidates, new ArrayList<>(), 0, target, 0);

        return result;        
    }
}