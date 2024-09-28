class MyCircularDeque {

    Deque<Integer> dq;
    int capacity, size = 0;

    public MyCircularDeque(int k) {
        dq = new ArrayDeque<>();
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if(size == capacity) return false;
        size++;
        dq.addFirst(value);
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size == capacity) return false;
        size++;
        dq.addLast(value);
        return true;
    }
    
    public boolean deleteFront() {
        if(size == 0) return false;
        dq.removeFirst();
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size == 0) return false;
        dq.removeLast();
        size--;
        return true;
    }
    
    public int getFront() {
        if(size == 0) return -1;
        return dq.peekFirst();
    }
    
    public int getRear() {
        if(size == 0) return -1;
        return dq.peekLast();
    }
    
    public boolean isEmpty() {
        return size == 0;        
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */