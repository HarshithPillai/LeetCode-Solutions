class Solution {
    public boolean canAliceWin(int[] nums) {
        int sumsin=0, sumdou=0;
        for(int v:nums) {
            if(v<10) sumsin+=v;
            else sumdou+=v;
        }
        return sumsin!=sumdou;
    }
}