class Solution {
    public int minOperations(String[] logs) {
        int curr = 0;
        for(String log:logs) {
            if(log.equals("../")) {
                curr--;
            } else if(log.equals("./")) {}
            else {
                curr++;
            }
            curr = Math.max(curr, 0);
        }
        return curr;
    }
}