class Solution {
    public int minIncrementForUnique(int[] nums) {
        /**
            1 1 2 2 3 7
            1 2 3 4 5 7
        */
        int ans = 0;
        int max = 0;
        for(int num:nums) max = Math.max(max, num);
        int freq[] = new int[nums.length+max+1];
        for(int num:nums) {
            freq[num]++;
        }
        int last = -1;
        for(int i=0; i<freq.length; i++) {
            // last = Math.max(last, i);
            if(freq[i]==0) {
                continue;
            }
            if(last>=i) {
                ans+=(last-i+1)*freq[i];
            }
            ans+=((freq[i]-1)*freq[i])/2;
            if(last>=i) last = last+freq[i];
            else last = i+freq[i]-1;
        }
        return ans;
    }
}