class Solution {
    public void merge(int[] nums, int s, int m, int e) {
        int arr[] = new int[e-s+1];
        int i=s, j = m+1, ind = 0;
        while(i<=m && j<=e) {
            if(nums[i] < nums[j]) {
                arr[ind] = nums[i];
                i++;
            } else {
                arr[ind] = nums[j];
                j++;
            }
            ind++;
        }
        while(i<=m) {
            arr[ind] = nums[i];
            i++; ind++;
        }
        while(j<=e) {
            arr[ind] = nums[j];
            j++; ind++;
        }
        for(int k=s; k<=e; k++) {
            nums[k] = arr[k-s];
        }
    }
    public void mergeSort(int[] nums, int s, int e) {
        if(s >= e) return;
        int m = (s+e)/2;
        mergeSort(nums, s, m);
        mergeSort(nums, m+1, e);
        merge(nums, s, m, e);
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}