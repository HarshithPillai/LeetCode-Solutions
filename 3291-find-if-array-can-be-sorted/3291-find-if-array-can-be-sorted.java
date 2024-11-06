class Solution {
    public boolean merge(int[] nums, int s, int mid, int e) {
        int temp[] = new int[e-s+1];
        int l = s, r = mid+1, ind = 0;
        while(l<=mid && r<=e) {
            if(nums[l] <= nums[r]) {
                temp[ind] = nums[l];
                l++;
            } else {
                int countL = 0, countR = 0;
                for(int shift = 0; shift<10; shift++) {
                    int mask = 1<<shift;
                    if((nums[r] & mask) != 0) countR++;
                }
                for(int i=l; i<=mid; i++) {
                    countL = 0;
                    for(int shift = 0; shift<10; shift++) {
                        int mask = 1<<shift;
                        if((nums[i] & mask) != 0) countL++;
                    }
                    if(countL != countR) return false;
                }
                temp[ind] = nums[r];
                r++;
            }
            ind++;
        }
        while(l<=mid) {
            temp[ind++] = nums[l++];
        }
        while(r<=e) {
            temp[ind++] = nums[r++];
        }
        ind=0;
        for(int i=s; i<=e; i++) {
            nums[i] = temp[ind];
            ind++;
        }
        return true;
    }
    public boolean mergeSort(int[] nums, int s, int e) {
        if(s == e) return true;
        int mid = s + (e-s)/2;
        boolean flag = true;
        flag &= mergeSort(nums, s, mid);
        flag &= mergeSort(nums, mid+1, e);
        flag &= merge(nums, s, mid, e);
        return flag;
    }
    public boolean canSortArray(int[] nums) {
        boolean sorted = true;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] < nums[i-1]) sorted = false;
        }
        if(sorted) return true;
        return mergeSort(nums, 0, nums.length-1);
    }
}