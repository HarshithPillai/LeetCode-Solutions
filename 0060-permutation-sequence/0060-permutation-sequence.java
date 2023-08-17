import java.util.*;
class Solution {
    public String getPermutation(int n, int k) {
        int fact=1;
        List<Integer> list = new ArrayList<>();
        
        for(int i=1; i<n;i++) {
            fact=fact*i;
            list.add(i);
        }
        list.add(n);
        k--;
        String res="";
        while(true) {
            res+=list.get(k/fact);
            list.remove(k/fact);
            if(list.size()==0) {
                break;
            }
            if(list.size()==1) {
                res+=""+list.get(0);
                break;
            }
            k=k%fact;
            
            fact=1;
            for(int i=1;i<list.size();i++) {
                fact=fact*i;
            }
        }

        return res;
    }
}