class Solution {
    public void helper(int[] candidates, int target, int ind, List<Integer> curr, List<List<Integer>> res) {
        if(target<0) return;
        if(target==0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(ind==candidates.length) return;
        for(int i=ind; i<candidates.length; i++) {
            if(i>ind && candidates[i]==candidates[i-1]) continue;
            curr.add(candidates[i]);
            helper(candidates, target-candidates[i], i+1, curr, res);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>(), res);
        //Collections.sort(res);
        return res;
    }
}