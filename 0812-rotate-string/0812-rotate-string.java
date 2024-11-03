class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        int n = s.length();
        for(int i=0; i<n; i++) {
            boolean found = true;
            for(int j=i; j<n; j++) {
                if(s.charAt(j) != goal.charAt(j-i)) {
                    found = false;
                    break;
                }
            }
            for(int j=0; found && j<i; j++) {
                if(s.charAt(j) != goal.charAt(n-i+j)) {
                    found = false;
                    break;
                }
            }
            if(found) return true;
        }
        return false;
    }
}