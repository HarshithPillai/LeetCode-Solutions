class Solution {
    public void recUtil(List<List<Integer>> result, List<Integer> list, int sum, int target, int count, int ind) {
        if(sum==target && list.size()==count) {
            result.add(new ArrayList<>(list));
            return;
        }
        if(sum>target || list.size()==count) return;
        for(int i=ind; i<10; i++) {
            list.add(i);
            recUtil(result,list,sum+i,target,count,i+1);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        recUtil(result, new ArrayList<>(), 0, n, k, 1);
        return result;
    }
}