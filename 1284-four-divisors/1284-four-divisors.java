class Solution {
    int fourDivisors(int num) {
        int val = 0, sum = 0;
        for(int i=1; i*i<=num; i++) {
            if(num%i==0) {
                val++;
                sum+=i;
                if(i*i!=num) {
                    val++;
                    sum+=num/i;
                }
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