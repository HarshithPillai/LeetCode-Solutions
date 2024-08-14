class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> freq = new HashMap<>();
        int l=0, r=0, n = fruits.length, ans=0;
        while(r<n) {
            int val = fruits[r];
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            while(freq.size() > 2) {
                int count = freq.get(fruits[l]);
                if(count == 1) freq.remove(fruits[l]);
                else freq.put(fruits[l], count-1);
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}