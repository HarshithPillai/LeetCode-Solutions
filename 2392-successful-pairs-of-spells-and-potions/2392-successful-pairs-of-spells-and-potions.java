class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        Arrays.sort(potions);
        int[] ans = new int[n];
        int m = potions.length;
        for(int i=0; i<n; i++) {
            int l=0, h = m-1;
            while(l<=h) {
                int mid = l + (h-l)/2;
                long val = (long)potions[mid] * (long)spells[i];
                if(val >= success) {
                    h = mid - 1;
                } else l = mid + 1;
            }
            ans[i] = m - l;
        }
        return ans;
    }
}