class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i:nums) {
            set.add(i);
        }
        int count=0;
        for(int i: nums) {
            int curr=i, currentCount=1;
            while(set.contains(curr+1)) {
                currentCount++;
                set.remove(curr);
                curr++;
            }
            curr=i;
            while(set.contains(curr-1)) {
                currentCount++;
                set.remove(curr);
                curr--;
            }
            if(count<currentCount) count=currentCount;
        }
        return count;
    }
}