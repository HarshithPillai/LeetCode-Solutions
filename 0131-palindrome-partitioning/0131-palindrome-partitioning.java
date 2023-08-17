class Solution {
    public boolean isPalindrome(String s) {
        int i=0; int j=s.length()-1;
        while(i<=j) {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }

    public void recUtil(List<List<String>> result, List<String> list, String curr, String s) {
        
        if(0==curr.length()) {
            //if(isPalindrome(str.peek()));
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<curr.length(); i++) {
            String a=curr.substring(0,i+1);
            String b=curr.substring(i+1);
            if(isPalindrome(a)) {
                list.add(a);
                recUtil(result, list, b, s);
                list.remove(list.size()-1);
            }
        }
        
    }

    public List<List<String>> partition(String s) {
        int n=s.length();
        
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        
        recUtil(result, list, s, s);

        return result;

    }
}