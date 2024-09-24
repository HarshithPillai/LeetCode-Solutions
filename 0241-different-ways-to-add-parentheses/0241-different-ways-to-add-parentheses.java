class Solution {
    public List<Integer> helper(String exp, int l, int r) {
        if(r<l) return new ArrayList<>();
        if(r-l < 2) {
            List<Integer> temp = new ArrayList<>();
            temp.add(Integer.parseInt(exp.substring(l, r+1)));
            return temp;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=l+1; i<r; i++) {
            char ch = exp.charAt(i);
            if(ch == '*' || ch == '+' || ch == '-') {
                List<Integer> left = helper(exp, l, i-1);
                List<Integer> right = helper(exp, i+1, r);
                for(int l1:left) {
                    for(int r1:right) {
                        if(ch == '*') {
                            int val = l1 * r1;
                            ans.add(val);
                        } else if(ch == '+') {
                            int val = l1 + r1;
                            ans.add(val);
                        } else {
                            ans.add(l1 - r1);
                        }
                    }
                }
            }
        }
        return ans;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression, 0, expression.length()-1);
    }
}