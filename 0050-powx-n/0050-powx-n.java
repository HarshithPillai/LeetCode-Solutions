class Solution {
    public double myPowU(double x, int n) {
        if(n<0) {
            double ansN = myPowU(x,-(n/2));
            if(n%2==0) return 1/(ansN*ansN);
            return (1/x) * (1/(ansN*ansN));
        }
        if(n==0) return 1;
        
        double ans1=myPowU(x, n/2);
        if(n%2==1) return x*ans1*ans1;
        return ans1*ans1;
    }
    public double myPow(double x, int n) {
        return myPowU(x, n);
    }
}