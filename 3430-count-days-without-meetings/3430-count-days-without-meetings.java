class Solution {
    public int countDays(int days, int[][] meetings) {
        /**
            integer days representing the total number of days an employee is available for work
            from day 1
            2D array meetings of size n
            where, meetings[i] = [start, end]
            return count of days when employee is available for work but no meetings are scheduled
        */

        Arrays.sort(meetings, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        int last = 0, ans = 0;
        for (int[] meet : meetings) {
            int s = meet[0], e = meet[1];
            if (s > last) {
                ans += s - last - 1;
            }
            last = Math.max(last, e);
        }

        if (days > last) ans += days - last;

        return ans;
    }
}