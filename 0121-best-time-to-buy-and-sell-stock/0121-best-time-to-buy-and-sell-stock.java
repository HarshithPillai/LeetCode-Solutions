class Solution {
    public int maxProfit(int[] prices) {
        // find longest increasing slope
        int minYet=prices[0];
        int maxVal=0;
        for(int i=1; i<prices.length; i++) {
            if(minYet>prices[i])  {
                minYet=prices[i];
            } 

            int curr = prices[i]-minYet;
            if(maxVal<curr)
                maxVal=curr;

        }
        return maxVal;
    }
}