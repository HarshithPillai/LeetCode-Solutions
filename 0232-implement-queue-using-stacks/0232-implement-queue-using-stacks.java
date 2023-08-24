class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        while(!output.isEmpty()) {
            input.push(output.pop());
        }
        input.push(x);
    }
    
    public int pop() {
        while(!input.isEmpty()) {
            output.push(input.pop());
        }
        return output.pop();
    }
    
    public int peek() {
        while(!input.isEmpty()) {
            output.push(input.pop());
        }
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */