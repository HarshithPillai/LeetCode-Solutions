class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list 
            = new ArrayList<List<Integer>>();
        for(int i=1; i<=numRows; i++) {
            
            ArrayList<Integer> temp = new ArrayList<>();
            
            if(i==1) {
                temp.add(1);
            } else {
                for(int j=1; j<=i; j++) {
                    if(j==1 || j==i) {
                        temp.add(1);
                    } else {
                        int val = list.get(i-2).get(j-1) 
                                    + list.get(i-2).get(j-2);
                        temp.add(val);
                    }
                }
            }
            
            list.add(temp);
        }
        return list;
    }
}