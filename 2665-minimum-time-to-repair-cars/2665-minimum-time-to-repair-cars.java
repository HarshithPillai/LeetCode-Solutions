class Solution {
    int n;
    public boolean helper(int[] ranks, int cars, long mid) {
        for (int rank : ranks) {
            int possible = (int) Math.sqrt(mid / rank);
            cars -= possible;
            if (cars <= 0) return true;
        }
        return false;
    }
    public long repairCars(int[] ranks, int cars) {
        /**
            r = ranks[i] is the rank of the i'th mechanic.
            a mechanic with a rank r can repair n cars in r * n^2 minutes
            integer 'cars' = total number of cars waiting in the garage to be repaired
            return the minimum time taken to repair all the cars
        */
        Arrays.sort(ranks);
        n = ranks.length;
        long l = 1, r = ((long) ranks[n-1]) * cars * cars;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (helper(ranks, cars, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}