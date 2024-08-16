class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int m = arrays.size();
        int firstminind = -1, firstmin = (int)1e9, firstmaxind = -1, firstmax = -(int)1e5;
        int secondminind = -1, secondmin = (int)1e9, secondmaxind = -1, secondmax = -(int)1e5;
        for(int i=0; i<m; i++) {
            int f = arrays.get(i).get(0);
            if(f < firstmin) {
                secondmin = firstmin;
                secondminind = firstminind;
                firstmin = f;
                firstminind = i;
            } else if(f<secondmin) {
                secondmin = f;
                secondminind = i;
            }
            int l = arrays.get(i).get(arrays.get(i).size()-1);
            if(l > firstmax) {
                secondmax = firstmax;
                secondmaxind = firstmaxind;
                firstmax = l;
                firstmaxind = i;
            } else if(l > secondmax) {
                secondmax = l;
                secondmaxind = i;
            }
        }
        if(firstminind == firstmaxind) {
            return Math.max(Math.abs(firstmax-secondmin), Math.abs(secondmax-firstmin));
        }
        return Math.abs(firstmax-firstmin);
    }
}