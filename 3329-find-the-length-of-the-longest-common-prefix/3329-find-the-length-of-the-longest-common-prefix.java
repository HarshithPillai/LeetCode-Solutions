class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for(int num:arr2) {
            while(num>0) {
                set.add(num);
                num/=10;
            }
        }
        int max = 0;
        for(int num:arr1) {
            while(num>0) {
                if(set.contains(num)) {
                    max = Math.max(max, num);
                }
                num/=10;
            }
        }
        int count = 0;
        while(max>0) {
            count++;
            max/=10;
        }
        return count;
    }
}