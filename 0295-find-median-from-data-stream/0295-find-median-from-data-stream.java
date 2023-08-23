class MedianFinder {

    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(!max.isEmpty() && num<max.peek()) {
            max.add(num);
        } else {
            min.add(num);
        }

        if(max.size()<min.size()) {
            max.add(min.poll());
        } else if(min.size()+1<max.size()) {
            min.add(max.poll());
        }
    }
    
    public double findMedian() {
        int size = max.size() + min.size();
        if(size%2!=0) {
            return (double)max.peek();
        } else {
            return (double)(max.peek()+min.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */