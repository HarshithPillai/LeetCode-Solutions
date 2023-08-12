class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n=nums.length;
        int sum=0;
        int count=0;
        map.put(0,1);
        for(int i=0; i<n; i++) {
            sum+=nums[i];
            
            count+=(map.containsKey(sum-k))?map.get(sum-k):0;

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
            
        }

        return count;
    }
}