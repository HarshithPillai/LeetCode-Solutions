class Solution {
    public boolean closeStrings(String word1, String word2) {
        char[] a = word1.toCharArray(), b = word2.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for(char ch:a) map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        for(char ch:b) map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        List<Character> l1 = new ArrayList<>(map1.keySet()), l2 = new ArrayList<>(map2.keySet());
        if(l1.size() != l2.size()) return false;
        Collections.sort(l1);
        Collections.sort(l2);
        for(int i=0; i<l1.size(); i++) {
            if(!l1.get(i).equals(l2.get(i))) {
                return false;
            }
        }
        List<Integer> l1i = new ArrayList<>(map1.values()), l2i = new ArrayList<>(map2.values());
        if(l1i.size() != l2i.size()) return false;
        Collections.sort(l1i);
        Collections.sort(l2i);
        for(int i=0; i<l1i.size(); i++) {
            if(!l1i.get(i).equals(l2i.get(i))) {
                return false;
            }
        }

        return true;
    }
}