class Solution {
    public int[] lexicographicallySmallestArray(int[] val, int limit) {
        List<Queue<Integer>> list = new ArrayList<>();
        list.add(new LinkedList<>());
        int[] nums = new int[val.length];
        for(int i=0; i<val.length; i++) nums[i] = val[i];
        Arrays.sort(nums);
        int ind = 0, n = nums.length;
        Map<Integer, Integer> index = new HashMap<>();
        for(int i=0; i<n; i++) {
            Queue<Integer> q = list.get(ind);
            if(!q.isEmpty() && Math.abs(nums[i] - nums[i-1]) > limit) {
                list.add(new LinkedList<>());
                ind++;
                q = list.get(ind);
            }
            q.add(nums[i]);
            index.put(nums[i], ind);
        }
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            ans[i] = list.get(index.get(val[i])).poll();
        }
        return ans;
    }
}