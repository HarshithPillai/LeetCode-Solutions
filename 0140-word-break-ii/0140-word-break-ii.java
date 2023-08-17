class Solution {
    public void recUtil(List<String> result, String curr, List<String> dict, String res) {
        if(curr.length()==0) {
            result.add(res);
            return;
        }
        int size = dict.size();
        for(int i=0; i<size; i++) {
            //TRIM BEFORE ADDING TO RESULT
            String word = dict.get(i);
            int len = word.length();
            if(curr.length()<len) continue;
            String a = curr.substring(0, len);
            String b = curr.substring(len);
            if(a.equals(word)) {
                String temp=res;
                if(res.length()==0) {
                    temp=word;
                } else {
                    temp+=" "+word;
                }
                recUtil(result, b, dict, temp);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        recUtil(result, s, wordDict, "");
        return result;
    }
}