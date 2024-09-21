class Solution {
    public void dfs(List<Integer> arr, int n, int val) {
        if(val>n) return;
        arr.add(val);
        for(int i=0; i<=9; i++) {
            dfs(arr, n, val*10+i);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> arr = new ArrayList<>();
        for(int i=1; i<=9; i++) {
            dfs(arr, n, i);
        }
        return arr;
    }
}