class Solution {
    public long minEnd(int N, int X) {
        N--;
        long n = N, x = X;
        int ind = 0;
        for(int i=0; i<64; i++) {
            if((x & (1L<<i)) != 0) continue;
            x |= ((n & (1L<<ind)) > 0 )? (1l<<i) : 0l ;
            ind++;
        }
        return x;
    }
}