class Solution {

    public int merge(int[] nums, int s, int m, int e) {
        int sizeA = m-s+1;
        int sizeB = e-m;

        int[] arrA = new int[sizeA];
        int[] arrB = new int[sizeB];

        for(int i=0; i<sizeA; i++) {
            arrA[i]=nums[s+i];
        }
        for(int i=0; i<sizeB; i++) {
            arrB[i]=nums[m+1+i];
        }

        // only checking for reverse pairs
        int i=0, j=0, k=s, res=0;
        while(i<sizeA && j<=sizeB) {
            if(j==sizeB){
                res+=j;
                i++;
            } else if((long)arrB[j]*2<(long)arrA[i]) {
                j++;
            } else {
                res+=j;
                i++;
            }
        }

        j=0; i=0;
        while(i<sizeA && j<sizeB) {
            if(arrA[i]>arrB[j]) {
                nums[k]=arrB[j];
                j++;
            } else {
                nums[k]=arrA[i];
                i++;
            }
            k++;
        }

        while(i<sizeA) {
            nums[k++]=arrA[i++];
        }
        while(j<sizeB) {
            nums[k++]=arrB[j++];
        }

        return res;
    }

    public int mergeSort(int[] nums, int s, int e) {
        int m=(s+e)/2;
        if(s>=e) return 0;
        int res=0;
        res+=mergeSort(nums, s, m);
        res+=mergeSort(nums, m+1, e);
        return res+merge(nums, s, m, e);
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}