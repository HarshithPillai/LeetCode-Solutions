class Solution {
    class Pair {
        String str;
        int count;
        Pair(String s, int c) { str=s; count=c; }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<Pair> q = new LinkedList<>();

        ///
        int n=beginWord.length();
        int count=0;
        q.add(new Pair(beginWord, 1));
        while(!q.isEmpty()) {
            Pair top=q.poll();
            if(top.str.equals(endWord)) return top.count;
            for(int i=0; i<n; i++) {
                char[] arr = top.str.toCharArray();
                for(int j=0; j<26; j++) {
                    arr[i]=(char)('a'+j);
                    String curr=new String(arr);
                    
                    if(dict.contains(curr)) {
                        dict.remove(curr);
                        q.add(new Pair(curr,top.count+1));
                    }
                }
            }
        }
        
        return 0;
    }
}