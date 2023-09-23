class Solution {
    public boolean compare(String a1, String b1) {
        int n1=a1.length(), n2=b1.length();
        if(n1!=(n2+1)) return false;
        int i=0, j=0;
        char[] a=a1.toCharArray(), b=b1.toCharArray();
        while(i<n1 && j<n2) {
            if(a[i]==b[j]) {
                i++;j++;
            } else {
                i++;
            }
        }
        if(i==n1 && j==n2) return true;
        if(i==n1-1 && j==n2) return true;
        return false;
    }
    public int longestStrChain(String[] words) {
        int n=words.length, dp[]=new int[n+1];
        Arrays.sort(words,(x,y)->x.length()-y.length());
        int max=1;
        for(int i=0;i<n;i++) {
            dp[i]=1;
            for(int j=0;j<i;j++) {
                if(dp[i]<dp[j]+1 && compare(words[i],words[j])) {
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(max, dp[i]);
        }
        return max;
    }
}