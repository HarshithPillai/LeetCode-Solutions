class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        /**
            n * n exactly once except a which appears twice and b which is missing.
            Sum of all values in the matrix - sum [1, n*n] = y - x
            y = extra num
            x = missing num

            sum of squares:
            matrix values:        1^2 + 2^2 + .. + y^2 + y^2 + .. + (n^2)^2
            valid values[1, n^2]: 1^2 + 2^2 + .. + y^2 + x^2 + .. + (n^2)^2
            subtract these two:
                (y^2 - x^2) / (y - x) = y + x
        */

        long n = grid.length, sqValid = (n*n) * (n*n+1) * (2*n*n + 1)/6, sqMatrix = 0, valid = (n*n) * (n*n + 1)/2, matrix = 0;

        for (int i = 0; i < n; i++) {
            for (int val : grid[i]) {
                sqMatrix += val*val;
                matrix += val;
            }
        }

        long sqDiff = sqMatrix - sqValid, yMinusX = matrix - valid, yPlusX = sqDiff / yMinusX;

        return new int[]{(int)(yPlusX + yMinusX) / 2, (int)(yPlusX - yMinusX) / 2};
    }
}