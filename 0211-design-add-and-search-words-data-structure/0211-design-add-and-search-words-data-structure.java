class WordDictionary {

    public Set<String> set;
    public WordDictionary() {
        set = new HashSet<>();
    }
    
    public void addWord(String word) {
        // char[] arr = word.toCharArray();
        // set.add(arr);
        set.add(word);
    }
    
    public boolean search(String word) {
        return helper(word.toCharArray(), 0);
    }

    private boolean helper(char[] word, int ind) {
        if(ind == word.length) return set.contains(new String(word));
        if(word[ind]=='.') {
            for(char a = 'a'; a<='z'; a++) {
                word[ind] = a;
                if(helper(word, ind+1)) return true;
                word[ind] = '.';
            }
            return false;
        } else return helper(word, ind+1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */