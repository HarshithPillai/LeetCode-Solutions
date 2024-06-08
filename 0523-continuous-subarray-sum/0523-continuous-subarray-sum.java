class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length, sum = 0;
        if(n==1) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<n; i++) {
            sum+=nums[i];
            if(map.containsKey(sum%k) && map.get(sum%k)<i-1) return true;
            if(!map.containsKey(sum%k)) map.put(sum%k, i);
        }
        return false;
    }
}