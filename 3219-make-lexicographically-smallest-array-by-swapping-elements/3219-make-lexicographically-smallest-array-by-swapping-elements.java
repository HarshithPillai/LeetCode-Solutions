class Solution {
    public int[] lexicographicallySmallestArray(int[] val, int limit) {
        int ind = 0, n = val.length;
        List<Queue<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> index = new HashMap<>();

        int[] nums = new int[n];
        for(int i=0; i<val.length; i++) nums[i] = val[i];
        Arrays.sort(nums);
        
        list.add(new LinkedList<>());
        
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
        for(int i=0; i<n; i++) {
            val[i] = list.get(index.get(val[i])).poll();
        }
        return val;
    }
}