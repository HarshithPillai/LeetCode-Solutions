class Solution {
    public int[] nextVal(String exp, int ind) {
        int i=ind;
        while(i<exp.length() && exp.charAt(i) != '/') i++;
        int[] res = new int[3];
        res[0] = Integer.parseInt(exp.substring(ind, i));
        int j = i+1;
        while(j<exp.length() && exp.charAt(j) != '-' && exp.charAt(j) != '+') j++;
        if(i+1 != j) res[1] = Integer.parseInt(exp.substring(i+1, j));
        else res[1] = 1;
        res[2] = j;
        return res;
    }
    public String fractionAddition(String expression) {
        int num = 0, den = 1;
        char[] arr = expression.toCharArray();
        int ind = 0;
        while(ind < expression.length()) {
            int[] curr = nextVal(expression, ind);
            // System.out.println(curr[0]+" "+curr[1]+" "+curr[2]);
            if(den != curr[1]) {
                int lcm = den*curr[1];
                num = curr[0]*den + num*curr[1];
                den = lcm;
            } else {
                num = curr[0] + num;
            }
            // System.out.println(num+" "+den);
            ind = curr[2];
        }
        for(int i=2; i<=Math.max(Math.abs(num), Math.abs(den)); i++) {
            // System.out.println("inside divider "+num+" "+den);
            while(num%i==0 && den%i==0) {
                num/=i; den/=i;
            }
        }
        return num+"/"+den;
    }
}