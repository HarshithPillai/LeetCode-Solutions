class Solution {
    public boolean recUtil(List<String> list, String curr, Map<String, Boolean> map) {
        int n=curr.length();
        int size = list.size();
        if(map.containsKey(curr)) return map.get(curr);
        if(n==0) return true;
        for(int i=0; i<size; i++) {
            String word = list.get(i);
            int len = word.length();
            if(len>n) continue;
            String a = curr.substring(0, len);
            String b = curr.substring(len);
            if(a.equals(word)) {
                if(recUtil(list, b, map)) {
                    map.put(curr, true);
                    return true;
                }
            }
            // String a = curr.substring(0, i+1);
            // String b = curr.substring(i+1);
            // //System.out.println(a+" "+b);
            // if(set.contains(a)) {
            //     if(recUtil(set, b)) {
            //         return true;
            //     }
            // }

        }
        map.put(curr, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // Set<String> set = new HashSet<>();
        // for(String t:wordDict) {
        //     set.add(t);
        // }
        Map<String, Boolean> map = new HashMap<>();
        return recUtil(wordDict, s, map);
    }
}