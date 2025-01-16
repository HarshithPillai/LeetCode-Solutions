class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, ans = 0;
        boolean nodd = (n%2 == 1), modd = (m%2 == 1);
        if(nodd && modd) {
            for(int i:nums1) ans ^= i;
            for(int i:nums2) ans ^= i;
        } else if(nodd) {
            for(int i:nums2) ans ^= i;
        } else if(modd) {
            for(int i:nums1) ans ^= i;
        }
        return ans;
    }
}