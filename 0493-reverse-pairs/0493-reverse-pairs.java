class Solution {

    public int countPairs(int[] nums, int s, int m, int e) {
        int j=m+1, res=0;
        for(int i=s; i<=m; i++) {
            while(j<=e && (long)nums[j]*2 < nums[i]) j++;
            res+=(j-(m+1));
        }
        return res;
    }

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

    public int mergeSort(int[] nums, int s, int e) {
        int m=(s+e)/2;
        if(s>=e) return 0;
        int res=0;
        res+=mergeSort(nums, s, m);
        res+=mergeSort(nums, m+1, e);
        res+=countPairs(nums, s, m, e);
        merge(nums, s, m, e);
        return res;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}