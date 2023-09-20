class Solution {
    public boolean compare(String a, String b) {
        int n1=a.length(), n2=b.length();
        int i=0, j=0;
        if(n2!=(n1+1)) return false;
        char[] arr=a.toCharArray(), barr=b.toCharArray();
        while(j<n2) {
            if(i<n1 && arr[i]==barr[j]) {
                i++; j++;
            } else {
                j++;
            }
        }
        
        if(j==n2 && i==n1) return true;
        
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