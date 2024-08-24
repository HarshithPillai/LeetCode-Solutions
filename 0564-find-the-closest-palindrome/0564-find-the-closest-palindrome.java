class Solution {

    public String buildPalindrome(long value, boolean isEven) {
        String val = String.valueOf(value);
        if(isEven) {
            return val + new StringBuilder(val).reverse().toString();
        } else {
            return val + new StringBuilder(val.substring(0, val.length()-1)).reverse().toString();
        }
    }

    public String nearestPalindromic(String n) {
        
        int len = n.length();
        
        if(len == 1) return Integer.toString(Integer.parseInt(n)-1);

        long actualValue = Long.parseLong(n);
        long firstHalf = Long.parseLong(n.substring(0, (len+1)/2));
        long same = Long.valueOf(buildPalindrome(firstHalf, len%2==0));
        long smaller = Long.valueOf(buildPalindrome(firstHalf-1, len%2==0));
        long bigger = Long.valueOf(buildPalindrome(firstHalf+1, len%2==0));
        long lesserDigits = (long) Math.pow(10, len-1) - 1;
        long moreDigits = (long) Math.pow(10, len) + 1;
        long ans = 0;

        long[] candidates = {same, smaller, bigger, lesserDigits, moreDigits};
        Arrays.sort(candidates);

        for(long candidate:candidates) {
            if(Math.abs(actualValue-ans) > Math.abs(actualValue-candidate) && candidate != actualValue) {
                ans = candidate;
            }
        }

        return String.valueOf(ans);
    }
}