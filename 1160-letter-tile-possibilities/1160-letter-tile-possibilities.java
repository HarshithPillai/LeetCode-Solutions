class Solution {
    int n;
    public void helper(Set<List<Character>> set, char[] arr, List<Character> curr, int[] vis) {
        for(int i=0; i<n; i++) {
            if(vis[i] == 1) continue;
            curr.add(arr[i]);
            vis[i]=1;
            set.add(new ArrayList<>(curr));
            helper(set, arr, curr, vis);
            curr.remove(curr.size()-1);
            vis[i] = 0;
        }
    }
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        n = arr.length;
        Set<List<Character>> set = new HashSet<>();
        set.add(new ArrayList<>());
        helper(set, arr, new ArrayList<>(), new int[n]);
        return set.size()-1;
    }
}