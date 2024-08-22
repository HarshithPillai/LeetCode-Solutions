class Solution {
    public int bitwiseComplement(int num) {
        if(num == 0) return 1;
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