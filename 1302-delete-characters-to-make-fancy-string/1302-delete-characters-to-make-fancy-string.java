class Solution {
    public String makeFancyString(String s) {
        char[] arr = s.toCharArray();
        char l1 = '/', l2 = '*';
        StringBuilder sb = new StringBuilder();
        for(char ch:arr) {
            if(ch == l1 && ch == l2) continue;
            l1 = l2;
            l2 = ch;
            sb.append(ch);
        }
        return new String(sb);
        
    }
}