class CustomStack {

    int arr[], n, ind;

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        n = maxSize;
        ind = -1;
    }
    
    public void push(int x) {
        if(ind+1 < n) {
            ind++;
            arr[ind] = x;
        }
    }
    
    public int pop() {
        if(ind>=0) {
            int val = arr[ind];
            ind--;
            return val;
        } else return -1;
    }
    
    public void increment(int k, int val) {
        for(int i=0; i<k && i<=ind; i++) {
            arr[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */