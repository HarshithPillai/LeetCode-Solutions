class Solution {
    public double averageWaitingTime(int[][] customers) {
        // Queue<int[]> q = new LinkedList<>();
        long time = 0, waittime = 0, n = customers.length;
        int i = 0;
        while(i<n) {
            int newtime = customers[i][0];
            int burst = customers[i][1];
            if(time<newtime) {
                time = newtime;
            }
            waittime += (time-newtime) + burst;
            time += burst;
            i++;
        }
        return waittime/((double)n);
    }
}