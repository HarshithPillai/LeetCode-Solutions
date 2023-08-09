class Solution {
    public int maxProfit(int[] prices) {
        // find longest increasing slope
        int minYet=0;
        int maxYet=minYet;
        int maxVal=0;
        for(int i=1; i<prices.length; i++) {
            if(prices[minYet]>prices[i])  {
                minYet=i;
                if(i>maxYet) maxYet=i;
            } else if(prices[i]>prices[maxYet]) {
                maxYet=i;
            }

            int curr = prices[maxYet]-prices[minYet];
            if(maxVal<curr)
                maxVal=curr;

        }
        return maxVal;
    }
}