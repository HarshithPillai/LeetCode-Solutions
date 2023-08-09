class Solution {
    public int maxProfit(int[] prices) {
        // find longest increasing slope
        int minYet=prices[0];
        int maxVal=0;
        for(int i=1; i<prices.length; i++) {
            minYet=Math.min(minYet,prices[i]);
   
            if(maxVal<prices[i]-minYet)
                maxVal=prices[i]-minYet;

        }
        return maxVal;
    }
}