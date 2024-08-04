class Solution {
    int MOD = (int)1e9 + 7;
    public int rangeSum(int[] nums, int n, int left, int right) {
        left--; right--;
        List<Integer> lt = new ArrayList<>();
        int[] prefix = new int[n];
        int prefsum = 0;
        for(int i=0; i<n; i++) {
            prefsum+=nums[i];
            prefix[i] = prefsum;
        }
        for(int i=0; i<n; i++) {
            int total = 0;
            for(int j=i; j<n; j++) {
                if(i==0) lt.add(prefix[j]);
                else lt.add(prefix[j] - prefix[i-1]);
            }
        }
        // System.out.println(lt);
        Collections.sort(lt);
        int sum = 0;
        for(int i=left; i<=right; i++) sum = (sum + lt.get(i))%MOD;
        return sum;
    }
}