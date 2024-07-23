class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for(Map.Entry<Integer, Integer> entry:freq.entrySet()) {
            List<Integer> lt = map.getOrDefault(entry.getValue(), new ArrayList<>());
            lt.add(entry.getKey());
            map.put(entry.getValue(), lt);
        }
        int n = nums.length;
        int[] ans = new int[n];
        int ind=0;
        for(Map.Entry<Integer, List<Integer>> entry:map.entrySet()) {
            Collections.sort(entry.getValue(), Collections.reverseOrder());
            for(int val:entry.getValue()) {
                int times = entry.getKey();
                while(times>0) {
                    ans[ind] = val;
                    ind++;
                    times--;
                }
            }
        }
        return ans;
    }
}