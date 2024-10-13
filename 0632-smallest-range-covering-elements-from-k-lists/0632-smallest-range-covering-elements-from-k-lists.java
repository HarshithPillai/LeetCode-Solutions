class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int max = -(int)1e6, k = nums.size(), range = (int)1e6, start = -1, end = -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
        for(int i=0; i<k; i++) {
            int val = nums.get(i).get(0);
            pq.add(new int[]{val, i, 0});
            max = Math.max(max, val);
        }
        // boolean flag = true;
        while(true) {
            int[] index = pq.poll();
            int val = index[0], listInd = index[1], ind = index[2];
            if(max - val < range) {
                start = val;
                end = max;
                range = max - val;
            }
            if(ind + 1 == nums.get(listInd).size()) break;
            pq.add(new int[]{nums.get(listInd).get(ind+1), listInd, ind+1});
            max = Math.max(max, nums.get(listInd).get(ind+1));
        }
        return new int[]{start, end};
    }
}