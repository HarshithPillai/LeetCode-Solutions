class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray(), tar = part.toCharArray();
        int n = str.length, m = tar.length;
        for(char ch:str) {
            if(ch == tar[m-1] && st.size() >= m-1) {
                List<Character> lt = new ArrayList<>();
                lt.add(ch);
                for(int i=1; i<m; i++) {
                    lt.add(st.pop());
                }
                boolean flag = true;
                for(int i=0; i<m; i++) {
                    if(lt.get(i) != tar[m-1-i]) {
                        flag = false;
                        break;
                    }
                }
                if(!flag) {
                    for(int i=m-1; i>=0; i--) {
                        st.add(lt.get(i));
                    }
                }
            } else {
                st.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb = sb.reverse();
        return new String(sb);
    }
}