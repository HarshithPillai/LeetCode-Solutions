class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length, count = 0, ltInd = 0, gtInd = 0;
        int[] lt = new int[n], gt = new int[n];
        for (int i : nums) {
            if (i > pivot) {
                gt[gtInd] = i;
                gtInd++;
            } else if (i < pivot) {
                lt[ltInd] = i;
                ltInd++;
            } else {
                count++;
            }
        }
        
        while (count > 0) {
            count--;
            lt[ltInd++] = pivot;
        }
        for(int i = 0; i < gtInd; i++) {
            lt[ltInd++] = gt[i];
        }
        return lt;
    }
}