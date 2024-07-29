class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length, ans = 0;
        int prevL[] = new int[n], prevG[] = new int[n], nextL[] = new int[n], nextG[] = new int[n];
        for(int i=1; i<n-1; i++) {
            int minL = 0, maxL = 0;
            int minR = 0, maxR = 0;
            for(int j=0; j<i; j++) {
                minL += (rating[j] < rating[i])?1:0;
                maxL += (rating[j] > rating[i])?1:0;
            }
            for(int j=i+1; j<n; j++) {
                minR += (rating[j] < rating[i])?1:0;
                maxR += (rating[j] > rating[i])?1:0;
            }
            ans += minR*maxL + maxR*minL;
        }
        return ans;
    }
}