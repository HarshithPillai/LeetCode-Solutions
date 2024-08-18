class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        int[] indices = {0,0,0};
        int[] primes = {2,3,5};
        for(int i=1; i<n; i++) {
            int[] nextUglies = new int[3];
            for(int j=0; j<3; j++) {
                nextUglies[j] = arr.get(indices[j]) * primes[j];
            }
            int minValue = Math.min(nextUglies[0], Math.min(nextUglies[1], nextUglies[2]));
            arr.add(minValue);
            for(int j=0; j<3; j++) {
                if(nextUglies[j] == minValue) indices[j]++;
            }
        }
        return arr.get(n-1);
    }
}