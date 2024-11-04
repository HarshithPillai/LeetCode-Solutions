class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        char curr = '.';
        char[] arr = word.toCharArray();
        for(char ch:arr) {
            if(ch == curr) {
                cnt++;
            } else {
                if(curr != '.') {
                    while(cnt >= 9) {
                        sb.append(9);
                        sb.append(curr);
                        cnt -= 9;
                    }
                    if(cnt > 0) {
                        sb.append(cnt);
                        sb.append(curr);
                    }
                }
                cnt = 1;
                curr = ch;
            }
        }
        while(cnt >= 9) {
            sb.append(9);
            sb.append(curr);
            cnt -= 9;
        }
        if(cnt > 0) {
            sb.append(cnt);
            sb.append(curr);
        }
        return new String(sb);
    }
}