class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        char[] arr = searchWord.toCharArray();
        int ind = 1;
        for(String word:sentence.split(" ")) {
            if(arr.length <= word.length()) {
                boolean found = true;
                for(int i=0; i<arr.length; i++) {
                    if(arr[i] != word.charAt(i)) {
                        found = false;
                        break;
                    }
                }
                if(found) return ind;
            }
            ind++;
        }
        return -1;
    }
}