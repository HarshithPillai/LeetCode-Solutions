class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> setList = new HashSet<>();
        int n=nums.length;
        for(int i=0; i<n-3; i++) {
            for(int j=i+1; j<n-2; j++) {
                Set<Long> set = new HashSet<>();
                for(int k=j+1; k<n; k++) {
                    long fourth = (long)target-(long)nums[i]-(long)nums[j]-(long)nums[k];
                    if(set.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add((int)nums[i]);temp.add((int)nums[j]);
                        temp.add((int)nums[k]);temp.add((int)fourth);
                        Collections.sort(temp);
                        setList.add(temp);
                    }
                    set.add((long)nums[k]);
                }
            }
        }
        return new ArrayList(setList);
    }
}