class Solution {
    public int findKthLargest(int[] nums, int k) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num > max)
                max = num;
            if(num < min)
                min = num;
        }
        int[] count = new int[max + 1 - min];

        for(int num : nums)
            count[num - min]++;

        for(int i = count.length - 1; i >= 0; i--) {
            k -= count[i];
            if(k <= 0)
                return i+min;
        }
        return -1; 
    }
}