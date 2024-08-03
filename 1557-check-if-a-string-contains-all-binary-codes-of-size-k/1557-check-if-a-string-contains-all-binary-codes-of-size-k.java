class Solution {
    public boolean hasAllCodes(String s, int k) {
        char[] arr = s.toCharArray();
        int l=0, r = k-1, n = arr.length;
        Set<Integer> set = new HashSet<>();
        for(; r<n; r++, l++) {
            int val = 0, exp = 0;
            for(int ind = r; ind>=l; ind--) {
                if(arr[ind] == '1') val += 1<<exp;
                exp++;
            }
            set.add(val);
        }
        int max = 1<<k;
        for(int i=0; i<max; i++) if(!set.contains(i)) return false;
        return true;
    }
}