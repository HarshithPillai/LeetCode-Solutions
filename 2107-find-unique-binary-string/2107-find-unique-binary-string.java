class Solution {
    String ans = null;
    Set<String> set;
    public void helper(char[] arr, int ind) {
        if(ind == -1) {
            String val = new String(arr);
            if(!set.contains(val)) {
                ans = val;
            }
            return;
        }
        if(ans != null) return;

        arr[ind] = '0';
        helper(arr, ind-1);
        arr[ind] = '1';
        helper(arr, ind-1);
    }
    public String findDifferentBinaryString(String[] nums) {
        set = new HashSet<>();
        for(String num : nums) set.add(num);
        int n = nums[0].length();
        char[] arr = new char[n];
        helper(arr, n-1);
        return ans;
    }
}