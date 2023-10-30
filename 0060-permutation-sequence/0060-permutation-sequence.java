//import java.util.*;
class Solution {
    /**
        123
        1 remains same for first 2 , 23 is 2 char long, length! = 2! = 2 
        1234
        1 remains same for first 6, 234 is 3 char long, 3! = 6
        (total_length - 1)! = fact
        8th permu of 1234
        k=7, first 6 will have 1 as the first
        1___, next will have the next element = k/fact = 7/6 = 1 
        which means index 1, second character [2];
        2___ is the correct permutation yet.
        remaining is 134, k = 7%fact = 7%6 = 1;
        k = 1, remaining = 134;
        fact = (length-1)! = 2! = 2;
        next element will be k/fact = 1/2 = 0;
        first element is the 0th index
        21__
    */
    public String getPermutation(int n, int k) {
        k--;// 0-based indexing
        List<Integer> list = new ArrayList<>();
        String res = "";
        for(int i=1;i<=n;i++) list.add(i);
        while(!list.isEmpty()) {
            int fact = 1;
            for(int i=1; i<=list.size()-1; i++) {
                fact*=i;
            }
            res = res + list.get(k/fact);
            list.remove(k/fact);
            k=k%fact;
        }
        return res;
    }
}