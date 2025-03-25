class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[2], a[2]);
            return Integer.compare(a[0], b[0]);
        });
        // sorted by x
        int sectionx = 0, lastx = 0, lasty = 0, sectiony = 0;
        for (int[] rect : rectangles) {
            if (lastx <= rect[0]) {
                sectionx++;
            }
            lastx = Math.max(rect[2], lastx);
        }
        if (sectionx >= 3) return true;
        Arrays.sort(rectangles, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(b[3], a[3]);
            return Integer.compare(a[1], b[1]);
        });
        for (int[] rect : rectangles) {
            if (lasty <= rect[1]) {
                sectiony++;
            }
            lasty = Math.max(rect[3], lasty);
        }
        return sectiony >= 3;
    }
}