class Solution {
    char[] arr = {'a', 'b', 'c'};
    List<List<Character>> list = new ArrayList<>();
    public void helper(List<Character> lt, int last, int n) {
        if(n == 0) {
            list.add(new ArrayList<>(lt));
            return;
        }
        for(int i=0; i<3; i++) {
            if(i == last) continue;
            lt.add(arr[i]);
            helper(lt, i, n - 1);
            lt.remove(lt.size() - 1);
        }
    }
    public String getHappyString(int n, int k) {
        List<Character> lt = new ArrayList<>();
        helper(lt, -1, n);
        StringBuilder sb = new StringBuilder();
        if(list.size() < k) return "";
        lt = list.get(k-1);
        for(char ch : lt) sb.append(ch);
        return new String(sb);
    }
}