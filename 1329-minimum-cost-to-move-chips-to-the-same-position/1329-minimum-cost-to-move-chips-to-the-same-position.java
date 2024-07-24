class Solution {
    public int minCostToMoveChips(int[] position) {
        int min = 101, n=position.length;
        for(int i=0; i<n; i++) {
            int total = 0;
            for(int j=0; j<n; j++) {
                total+=Math.abs(position[i] - position[j])%2;
            }
            min = Math.min(total, min);
        }
        return min;
    }
}