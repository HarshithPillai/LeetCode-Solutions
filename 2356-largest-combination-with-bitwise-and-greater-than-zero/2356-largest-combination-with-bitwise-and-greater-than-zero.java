class Solution {
    public int largestCombination(int[] candidates) {
        int[] freq = new int[25];
        for(int val:candidates) {
            for(int i=0; i<25; i++) {
                int mask = 1<<i;
                if((val & mask) != 0) freq[i]++;
            }
        }
        int max = 0;
        for(int i=0; i<25; i++) max = Math.max(max, freq[i]);
        return max;
    }
}