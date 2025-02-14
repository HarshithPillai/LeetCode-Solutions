class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> lt = new ArrayList<>();
        int n = s1.length();
        
        for(int i=0; i<n; i++) {
            if(s1.charAt(i) != s2.charAt(i)) lt.add(i);
        }
        
        if(lt.size() == 0) return true;
        if(lt.size() == 2) {
            int i = lt.get(0), j = lt.get(1);
            boolean chk1 = (s1.charAt(i) == s2.charAt(j));
            boolean chk2 = (s1.charAt(j) == s2.charAt(i));
            return chk1 && chk2;
        }
        
        return false;
    }
}