class StockSpanner {

    Stack<Integer> st;
    List<Integer> arr;
    int ind=-1;

    public StockSpanner() {
        st = new Stack<>();
        arr = new ArrayList<>();
        ind = -1;
    }
    
    public int next(int price) {
        ind++;
        while(!st.isEmpty() && arr.get(st.peek()) <= price) st.pop();
        arr.add(price);
        int ans = 0;
        if(st.isEmpty()) ans = ind+1;
        else ans = ind-st.peek();
        st.push(ind);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */