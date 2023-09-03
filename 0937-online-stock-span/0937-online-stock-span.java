class StockSpanner {
    class Pair{
        int index, val;
        Pair(int i, int v) {index=i; val=v;}
    }
    int count;
    Stack<Pair> stack = new Stack<>();
    public StockSpanner() {
        count=0;
        stack = new Stack<>();
    }
    
    public int next(int price) {
        while(!stack.isEmpty() && stack.peek().val<=price) stack.pop();
        count++;
        int res=count-((!stack.isEmpty())?stack.peek().index:0);
        stack.push(new Pair(count, price));
        
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */