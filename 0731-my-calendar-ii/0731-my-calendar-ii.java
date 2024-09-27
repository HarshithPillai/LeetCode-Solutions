class MyCalendarTwo {

    List<int[]> ol, nonol;

    public MyCalendarTwo() {
        ol = new ArrayList<>();
        nonol = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] pair:ol) {
            int s = pair[0], e = pair[1];
            if(start < e  && end > s) {
                return false;
            }
        }
        for(int[] pair:nonol) {
            int s = pair[0], e = pair[1];
            if(start < e  && end > s) {
                ol.add(new int[]{Math.max(start, s), Math.min(end, e)});
            }
        }
        nonol.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */