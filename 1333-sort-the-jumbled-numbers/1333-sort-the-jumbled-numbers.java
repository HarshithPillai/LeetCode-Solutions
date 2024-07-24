class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        /**
            loop over all digits of it and replace it with mapping[digit]
        */
        int[] ans = new int[nums.length];
        int ind=0;
        List<int[]> lt = new ArrayList<>();
        for(int num:nums) {
            int exp = 1, val = num, res = 0;
            if(val == 0) res = mapping[0];
            while(val>0) {
                res+=(mapping[val%10] * exp);
                exp*=10;
                val/=10;
            }
            lt.add(new int[]{res, num});
            ind++;
        }
        lt.sort((a,b)-> Integer.compare(a[0], b[0]));
        for(int i=0; i<ind; i++) ans[i] = lt.get(i)[1];
        return ans;
    }
}