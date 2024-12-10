class Solution {
    public boolean check(String s) {
        char ch = s.charAt(0);
        for(int i=1; i<s.length(); i++) {
            if(ch != s.charAt(i)) return false;
        }
        return true;
    }
    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        String ans = "";
        int n = s.length();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<=n; j++) {
                String sub = s.substring(i, j);
                if(check(sub)) map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey();
            int count = entry.getValue();
            if(count >= 3 && str.length() > ans.length()) {
                ans = str;
            }
        }
        System.out.println(ans);
        return (ans.length() == 0) ? -1 : ans.length();
    }
}