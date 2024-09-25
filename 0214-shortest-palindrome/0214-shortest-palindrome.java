class Solution {
    public void reverse(char[] arr) {
        int l = 0, r = arr.length-1;
        while(l<r) {
            char t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }
    public String shortestPalindrome(String s) {
        char arr[] = s.toCharArray();
        reverse(arr);
        String reversed = new String(arr);
        // System.out.println(reversed);
        int n = arr.length;
        for(int i=0; i<n; i++) {
            if(s.substring(0, n-i).equals(reversed.substring(i, n))) {
                return reversed.substring(0, i) + s;
            }
        }
        return reversed + s;
    }
}