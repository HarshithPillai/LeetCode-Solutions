class Solution {
    public int findComplement(int num) {
        int max = 31;
        while((1<<max & num) == 0) max--;
        for(int i=0; i<=max; i++) {
            int mask = 1<<i;
            if((num & mask) != 0) num-=(mask);
            else num+=mask;
        }
        return num;
    }
}