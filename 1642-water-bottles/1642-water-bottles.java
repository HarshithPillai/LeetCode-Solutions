class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int curr = numBottles, empty=0, ans=0;
        while(curr>0) {
            ans+=curr;
            empty+=curr;
            curr = empty/numExchange;
            empty = empty%numExchange;
        }
        return ans;
    }
}