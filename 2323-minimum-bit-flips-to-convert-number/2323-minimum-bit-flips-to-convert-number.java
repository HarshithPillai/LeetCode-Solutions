class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        for(int mask=0; mask<31; mask++) {
            int val = 1<<mask;
            if((start & val) != (goal & val)) count++;
        }
        return count;
    }
}