class Solution {
    public boolean check(char[] arr, int mid, int k, int[][] prefix) {
        mid--;
        int n = prefix.length;
        for(int i=0; mid<n; i++, mid++) {
            int count = 0;
            for(int j=0; j<3; j++) {
                int totalLeft = 0;
                totalLeft = prefix[n-1][j] - prefix[mid][j] + ((i>0)?prefix[i-1][j]:0);
                if(totalLeft >= k) count++;
            }
            if(count == 3) return true;
        }
        return false;
    }
    public int takeCharacters(String s, int k) {
        if(k == 0) return 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[][] prefix = new int[n][3];
        for(int i=0; i<n; i++) {
            for(int j=0; j<3; j++) {
                if(i>0) prefix[i][j] = prefix[i-1][j];
            }
            prefix[i][arr[i] - 'a']++;
        }
        int l = 1, h = n, max = -1;
        while(l<=h) {
            int mid = l + (h-l)/2;
            if(check(arr, mid, k, prefix)) { // is it possible to get a subarray that leaves at least k of each characters
                l = mid + 1;
                System.out.println("passed: " + mid);
                max = Math.max(max, mid);
            } else {
                h = mid - 1;
            }
        }
        if(max == -1) {
            int count = 0;
            for(int i=0; i<3; i++) {
                if(prefix[n-1][i] >= k) count++;
            }
            if(count == 3) return n;
            else return -1;
        }
        return n - max;
    }
}