class Solution {

    public  static int res;

    // public void countPairs(int[] nums, int s, int m, int e) {
    //     int j=m+1;
    //     for(int i=s; i<=m; i++) {
    //         while(j<=e && (long)nums[j]*2 < nums[i]) j++;
    //         this.res+=(j-(m+1));
    //     }
        
    // }

    public void merge(int[] nums, int s, int m, int e) {
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

        
        int i=0, j=0, k=s;
        //countPairs(nums, s, m, e);
        j=m+1;
        for(i=s; i<=m; i++) {
            while(j<=e && (long)nums[j]*2 < (long)nums[i]) j++;
            this.res+=(j-(m+1));
        }
        

        i=0; j=0;
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
        
    }

    public void mergeSort(int[] nums, int s, int e) {
        int m=(s+e)/2;
        if(s>=e) return;
        
        mergeSort(nums, s, m);
        mergeSort(nums, m+1, e);
        
        merge(nums, s, m, e);
    }

    public int reversePairs(int[] nums) {
        this.res=0;
        mergeSort(nums, 0, nums.length-1);
        return this.res;
    }
}