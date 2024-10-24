class Solution {
    public String countAndSay(int n) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        n--;
        while(n-- > 0) {
            int count = 0, num = -1;
            List<Integer> curr = new ArrayList<>();
            for(int i=0; i<prev.size(); i++) {
                int val = prev.get(i);
                if(val != num) {
                    if(count>0) {
                        Stack<Integer> st = new Stack<>();
                        while(count>0) {
                            st.add(count%10);
                            count/=10;
                        }
                        while(!st.isEmpty()) curr.add(st.pop());
                        curr.add(num);
                    }
                    num = val;
                }
                count++;
            }
            Stack<Integer> st = new Stack<>();
            while(count>0) {
                st.add(count%10);
                count/=10;
            }
            while(!st.isEmpty()) curr.add(st.pop());
            curr.add(num);
            prev = curr;
        }
        StringBuilder sb = new StringBuilder();
        for(int i:prev) {
            sb.append(i);
        }
        return new String(sb);
    }
}