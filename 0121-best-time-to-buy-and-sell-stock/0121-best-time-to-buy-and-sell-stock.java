class Solution {
    public int maxProfit(int[] prices) {
        int minyet=prices[0];
        int max=0;
        for(int i:prices) {
            if(minyet>i) minyet=i;
            max=Math.max(max,i-minyet);
        }
        return max;
    }
}