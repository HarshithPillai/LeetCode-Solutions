class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i:nums) {
            if(i>max)max=i;
            if(i<min)min=i;
        }

        int[] arr = new int[max-min+1];

        for(int i:nums) arr[i-min]++;

        for(int i=max-min; i>=0; i--) {
            k-=arr[i];
            if(k<=0) return i+min;
        }
        return -1;
    }
}