class Solution {
    public int chalkReplacer(int[] chalk, int total) {
        long sum = 0;
        long k = total;
        for(int i:chalk) sum+=i;
        k%=sum;
        for(int i=0; i<chalk.length; i++) {
            if(chalk[i] > k) return i;
            k -= chalk[i];
        }
        return 0;
    }
}