class Solution {
    int n;
    public boolean check(List<Integer> nums, int[] count, int i) {
        return count[i] > (i + 1) / 2 && (count[n-1] - count[i] > (n - 1 - i) / 2);
    }
    public int minimumIndex(List<Integer> nums) {
        /**
            element x of arr [length m] is dominant if more than half the lements of arr have value x
            split arr at index i -> [0, i] + [i+1, n-1]
            both need to have same dominant element
        */
        int curr = -1, count = 0;
        n = nums.size();
        for (int i : nums) {
            if (count == 0) curr = i;
            if (curr != i) {
                count--;
            } else {
                count++;
            }
        }

        count = 0;
        
        int[] countPrefix = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == curr) count++;
            countPrefix[i] = count;
            // System.out.print(count + ", ");
        }

        for (int i = 0; i < n; i++) {
            if (check(nums, countPrefix, i)) return i;
        }
        return -1;
    }
}