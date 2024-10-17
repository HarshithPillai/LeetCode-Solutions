class Solution {
    public int maximumSwap(int num) {
        if(num == 0) return 0;
        List<Integer> lt = new ArrayList<>();
        while(num > 0) {
            lt.add(num%10);
            num /= 10;
        }
        int maxInd = -1, max = -1, swapInd = -1, n = lt.size();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            if(lt.get(i) > max) {
                max = lt.get(i);
                maxInd = i;
            }
            arr[i] = maxInd;
        }
        int ans = 0, exp = 1, flag = 0;
        for(int i=n-1; i>=0; i--) {
            int val = lt.get(i), next = lt.get(arr[i]);
            if(next > val && flag == 0)  {
                lt.set(i, next);
                lt.set(arr[i], val);
                flag = 1;
            }
            ans += lt.get(i);
            if(i>0) ans *= 10;
        }
        return ans;
    }
}