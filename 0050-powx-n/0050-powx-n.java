class Solution {
    public double myPow(double x, int n) {
        long nn=n;
        if(n<0) {
            nn*=-1;
        }
        double ans=1;
        while(nn>0) {
            if(nn%2==1) {
                nn--;
                ans*=x;
            } else {
                nn/=2;
                x*=x;
            }
        }
        if(n<0) ans=1/ans;
        return ans;
    }
}