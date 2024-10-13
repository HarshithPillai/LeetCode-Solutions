class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int min = (int)1e6, max = -(int)1e6, k = nums.size();
        int minList = -1, maxList = -1;
        int[] indices = new int[k], ans = new int[]{max, min};
        // boolean flag = true;
        while(true) {
            min = (int)1e6;
            max = -(int)1e6;
            for(int i=0; i<k; i++) {
                int ind = indices[i];
                int val = nums.get(i).get(ind);
                if(val > max) {
                    max = val;
                }
                if (val < min) {
                    min = val;
                    minList = i;
                }
            }
            // System.out.println(min + " " + max);
            if(ans[1] - ans[0] > max - min) ans = new int[]{min, max};
            indices[minList]++;
            if(indices[minList] == nums.get(minList).size()) break;
        }
        return ans;
    }
}