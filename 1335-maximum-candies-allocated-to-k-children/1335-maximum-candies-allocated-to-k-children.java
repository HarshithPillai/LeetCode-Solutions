class Solution {

    int n;
    public boolean helper(int[] candies, long mid, long k) {
        for (int i = n-1; i >= 0 && k > 0; i--) {
            // if (curr >= mid) {
            //     k--;
            //     curr -= mid;
            // } else {
            //     if (i > 0) curr = candies[i-1];
            //     i--;
            // }
            if (candies[i] >= mid) {
                k -= candies[i]/mid;
            }
        }
        return k <= 0;
    }

    public int maximumCandies(int[] candies, long k) {
        /**
            candies array
            you can divide each pile into any number of sub piles
            you cannot merge two piles together

            int k = allocate piles of candies to k children such that each child gets the SAME number of candies
            each child can be callocated candies from only one pile
            and some piles can go unused - no need to use all the piles
        */
        
        Arrays.sort(candies);
        n = candies.length;
        long l = 1, r = candies[n-1];
        // for (int pile : candies) r = Math.max(r, pile);
        
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (helper(candies, mid, k)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return (int) r;
    }
}