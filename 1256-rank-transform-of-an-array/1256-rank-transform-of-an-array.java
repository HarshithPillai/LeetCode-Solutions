class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for(int i=0; i<n; i++) res[i] = arr[i];
        Arrays.sort(res);
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for(int i=0; i<n; i++) {
            if(i>0 && res[i] != res[i-1]) {
                count++;
            }
            map.put(res[i], count);
        }
        for(int i=0; i<n; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}