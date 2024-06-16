class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        /**
            nums1 and nums2 of length n
            choose a subsequence of indices of length k

            nums1 is multiplied with the minimum of the selected elements from nums2

            3 1 3 2
            1 2 3 4
        */
        List<int[]> list = new ArrayList<>();
        int n = nums1.length;
        for(int i=0; i<n; i++) {
            list.add(new int[]{nums1[i], nums2[i]});
        }
        // Sorted both arrays in Descending order based on nums2
        Collections.sort(list, (a,b)->Integer.compare(b[1], a[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(a,b));
        long currSum=0, ans=0;
        for(int i=0; i<k-1; i++) {
            int val = list.get(i)[0];
            currSum+=val;
            pq.add(val);
        }
        for(int i=k-1; i<n; i++) {
            int val = list.get(i)[0];
            currSum+=val;
            pq.add(val);
            ans = Math.max(ans, currSum*list.get(i)[1]);
            if(!pq.isEmpty()) {
                currSum -= pq.poll();
            }
        }
        return ans;
    }
}