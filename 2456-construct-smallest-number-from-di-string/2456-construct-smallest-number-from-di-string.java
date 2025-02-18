class Solution {
    public boolean helper(List<Character> lt, char last, char[] pat, int ind, TreeSet<Character> set) {
        if(ind == pat.length) return true;
        for(char ch : set) {
            if(pat[ind] == 'I' && ch < last) continue;
            if(pat[ind] == 'D' && ch > last) continue;
            lt.add(ch);
            TreeSet<Character> temp = new TreeSet<>(set);
            temp.remove(ch);
            if(helper(lt, ch, pat, ind+1, temp)) return true;
            lt.remove(lt.size() - 1);
        }
        return false;
    }
    public String smallestNumber(String pattern) {
        /**
            0 indexed pattern of length n
            I or D
            num consists 1 to 9, each digit occurs AT MOST Once
            I means next digit is more than the current
        */

        List<Character> lt = new ArrayList<>();
        char[] pat = pattern.toCharArray();
        TreeSet<Character> set = new TreeSet<>();
        for(char ch = '1'; ch <= '9'; ch++) set.add(ch);
        for(char ch = '1'; ch <= '9'; ch++) {
            lt.add(ch);
            set.remove(ch);
            if(helper(lt, ch, pat, 0, set)) {
                StringBuilder sb = new StringBuilder();
                for(char charac:lt) sb.append(charac);
                return new String(sb);
            }
            lt.remove(0);
            set.add(ch);
        }
    
        return "";
    }
}