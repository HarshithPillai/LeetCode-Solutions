class Solution {
    public int ladderLength(String s, String e, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        int time = 1;
        Queue<String> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int z=0; z<size; z++) {
                String top = q.poll();
                if(top.equals(e)) return time;
                for(int i=0; i<top.length(); i++) {
                    char[] t = top.toCharArray();
                    for(char ch = 'a'; ch<='z'; ch++) {
                        t[i] = ch;
                        String temp = new String(t);
                        if(set.contains(temp)) {
                            set.remove(temp);
                            q.add(temp);
                        }
                    }
                }
            }
            time++;
        }
        return 0;
    }
}