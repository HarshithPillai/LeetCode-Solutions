class Solution {
    public int minimizeXor(int num1, int num2) {
        int count1 = 0, count2 = 0;
        for(int i = 0; i<31; i++) {
            if((num1 & (1<<i)) != 0) count1++;
            if((num2 & (1<<i)) != 0) count2++;
        }
        if (count1 == count2) return num1;
        if (count1 > count2) {
            int diff = count2, val = 0, ind = 30;
            while(diff > 0 && ind > -1) {
                if((num1 & (1<<ind)) != 0) diff--;
                ind--;
            }
            while(ind > -1) {
                val |= (num1 & (1<<ind));
                ind--;
            }
            // System.out.println("1");
            return val^num1;
        } else {
            int diff = count2 - count1, val = 0, ind = 0;
            while(diff > 0) {
                if((num1 & (1<<ind)) == 0) {
                    diff--;
                    val |= (1<<ind);
                }
                ind++;
            }
            // while(ind < 31) {
            //     val |= (num1 & (1<<ind));
            //     ind++;
            // }
            // System.out.println("2");
            return val^num1;
        }
    }
}