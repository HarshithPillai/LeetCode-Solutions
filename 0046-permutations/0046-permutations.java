class Solution {
    public void helper(List<List<Integer>> res, List<Integer> curr, int ind) {
        if(ind==-1) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=ind; i>=0; i--) {
            int temp = curr.get(ind);
            curr.set(ind, curr.get(i));
            curr.set(i, temp);
            helper(res,curr,ind-1);
            temp = curr.get(ind);
            curr.set(ind, curr.get(i));
            curr.set(i, temp);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for(int i:nums) curr.add(i);
        helper(res, curr, nums.length-1);
        return res;
    }
}