class Solution {
    public int minimumPushes(String word) {
        int ind=0, ans=0;;
        for(char ch:word.toCharArray()) {
            ans += ind/8+1;
            ind++;
        }
        return ans;
    }
}