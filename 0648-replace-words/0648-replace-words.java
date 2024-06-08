class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dict = new HashSet<>(dictionary);
        String[] arr = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i=0;  i<arr.length; i++) {
            String word = arr[i];
            for(int j=0; j<=word.length(); j++) {
                String sub = word.substring(0,j);
                if(dict.contains(sub)) {
                    word = sub;
                    break;
                }
            }
            if(i!=0) ans.append(" ");
            ans.append(word);
        }
        return new String(ans);
    }
}