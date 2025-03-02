class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> lt = new ArrayList<>();
        int ind = -1, n = nums1.length, m = nums2.length, i = 0, j = 0;
        while (i < n && j < m) {
            if (nums1[i][0] != nums2[j][0]) {
                if (nums1[i][0] < nums2[j][0]) {
                    lt.add(nums1[i]);
                    i++;
                } else {
                    lt.add(nums2[j]);
                    j++;
                }
            } else {
                nums1[i][1] += nums2[j][1];
                j++;
            }
        }

        while (i < n) {
            lt.add(nums1[i]);
            i++;
        }

        while (j < m) {
            lt.add(nums2[j]);
            j++;
        }

        int[][] ans = new int[lt.size()][2];
        for(int k = 0; k < lt.size(); k++) {
            ans[k][0] = lt.get(k)[0];
            ans[k][1] = lt.get(k)[1];
        }
        
        return ans;
    }
}