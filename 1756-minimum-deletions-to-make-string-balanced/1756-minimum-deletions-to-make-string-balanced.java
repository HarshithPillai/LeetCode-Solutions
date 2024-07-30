class Solution {
    public int minimumDeletions(String s) {
        /**
        */
        int pre=0, total=0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='b') {
                pre++;
            }
            if(s.charAt(i)=='a') {
                if(pre>0) {
                    pre--;
                    total++;
                }
            }
        }
        return total;
    }
}