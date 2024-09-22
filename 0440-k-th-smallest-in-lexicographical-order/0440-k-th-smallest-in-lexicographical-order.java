class Solution {
    public int countNodes(long curr, int n) {
        /**
            Math.min(neighbour - curr, n+1 - curr) in this level
        */
        int res = 0;
        long neighbour = curr+1;
        while(curr<=n) {
            res += Math.min(neighbour, n+1) - curr;
            curr*=10;
            neighbour*=10;
        }
        return res;
    }
    public int findKthNumber(int n, int k) {
        int res = 0, curr = 1, stepsTaken = 1;
        /**
            keep track of current value and steps already taken 
            get total steps needed to reach the end node in the current sub-tree
            this denotes how many nodes are there in this subtree
            now if this number plus the total steps already taken is MORE than k
            then that means our node resides in this sub-tree

            but if it is lesser than or equal to k, then it means that the node resides in the next sub-tree

        */
        while(stepsTaken < k) {
            int count = countNodes(curr, n);
            if(stepsTaken + count > k) {
                curr*=10;
                stepsTaken++;
            } else {
                curr++;
                stepsTaken += count;
            }
        }
        return curr;
    }
}