class Solution {
    public int largestAltitude(int[] gain) {
        int curr = 0, max = 0;
        for(int i:gain) {
            curr += i;
            max = Math.max(max, curr);
        }
        return max;
    }
}