class Solution {
    public boolean compare(String a, String b) {
        int diff=0;
        int i=a.length()-1,j=b.length()-1;
        if(j!=(i+1)) return false;
        char[] arr=a.toCharArray(), barr=b.toCharArray();
        while(j>-1 && i>-1) {
            if(arr[i]!=barr[j]) {
                j--;diff++;
            } else {
                i--;j--;
            }
        }
        
        if(j==-1 && i==-1) return true;
        if(i==-1 && j==0 && diff==0) return true;
        return false;
    }
    public int longestStrChain(String[] words) {
        int n=words.length;
        int[] dp = new int[n];
        int max=1;
        Arrays.sort(words, (x,y)->x.length()-y.length());
        for(int i=0;i<n;i++) {
            dp[i]=1;
            for(int j=0;j<i;j++) {
                if(1+dp[j]>dp[i] && compare(words[j],words[i])) {
                    dp[i]=1+dp[j];
                }
            }
            if(max<dp[i]) max=dp[i];
        }
        return max;
    }
}