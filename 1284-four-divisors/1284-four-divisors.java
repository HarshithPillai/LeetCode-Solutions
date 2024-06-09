class Solution {
    int fourDivisors(int num) {
        if(num==1) return 0;
        int val = 2, sum = 1 + num;
        for(int i=2; i<=num/2+1; i++) {
            if(num%i==0) {
                val++;
                sum+=i;
            }
            if(val>4) return 0;
        }
        return (val==4)?sum:0;
    }
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int num:nums) {
            sum+=fourDivisors(num);
        }
        return sum;
    }
}