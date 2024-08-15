class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10 = 0;
        for(int bill:bills) {
            if(bill == 5) count5++;
            else if(bill == 10) {
                if(count5 == 0) return false;
                count5--;
                count10++;
            } else {
                if((count5==0 || count10 == 0) && (count5 < 3)) return false;
                if(count5>0 && count10>0) {
                    count5--;
                    count10--;
                } else {
                    count5-=3;
                }
            }
        }
        return true;
    }
}