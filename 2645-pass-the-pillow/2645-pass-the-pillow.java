class Solution {
    public int passThePillow(int n, int time) {
        int times = time%(2*(n-1));
        if(times > (n-1)) {
            times -= n-1;
            return n - times;
        } else {
            return times+1;
        }
    }
}