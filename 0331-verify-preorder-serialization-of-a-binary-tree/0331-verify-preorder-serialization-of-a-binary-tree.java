class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        int curr = 1;
        if(arr[0].equals("#")) return arr.length == 1;
        for(String val:arr) {
            if(curr<=0) return false;
            if(!val.equals("#")) curr += 2;
            curr--;
        }
        return curr == 0;
    }
}