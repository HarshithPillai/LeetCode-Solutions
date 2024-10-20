class Solution {
    public List<Boolean> helper(char operator, List<Boolean> top, int ind) {
        List<Boolean> res = new ArrayList<>();
        if(operator == '!') {
            res.add(!(top.get(0)));
        } else if (operator == '|') {
            boolean val = false;
            for(boolean el:top) val |= el;
            res.add(val);
        } else {
            boolean val = true;
            for(boolean el:top) val &= el;
            res.add(val);
        }
        // System.out.println("\n" + operator + " " + ind);
        // for(boolean value:res) {
        //     System.out.print(value + " ");
        // }
        return res;
    }
    public boolean parseBoolExpr(String expression) {
        Stack<List<Boolean>> stack = new Stack<>();
        stack.add(new ArrayList<>());
        Stack<Character> op = new Stack<>();
        char[] arr = expression.toCharArray();
        int ind = 0;
        for(char ch:arr) {
            if(ch == 'f' || ch == 't') {
                stack.peek().add(ch == 't');
            } else if (ch == '(') {
                stack.add(new ArrayList<>());
            } else if (ch == ',') {
                //
            } else if (ch == ')') {
                char operator = op.pop();
                List<Boolean> top = stack.pop();
                List<Boolean> newtop = helper(operator, top, ind);
                stack.peek().addAll(newtop);
            } else {
                op.add(ch);
            }
            ind++;
        }
        return stack.peek().get(0);
    }
}