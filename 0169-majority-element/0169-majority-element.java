class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max=1, maxVal=nums[0];
        for(int i:nums) {
            if(map.containsKey(i)) {
                int cur=map.get(i)+1;
                if(cur>max) {
                    max=cur;
                    maxVal=i;
                }
                map.put(i, cur);
            } else {
                map.put(i, 1);
            }
        }

        return maxVal;
    }
}