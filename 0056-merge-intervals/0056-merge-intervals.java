class Solution {
    public boolean inContact(int x, int y, int i, int j) {
        return ((x<=i && y>=i)
            || (x<=j && y>=j)
            || (x>=i && y<=j));
            
    }

    public int[][] merge(int[][] intervals) {

        //sort array using first element of each interval
        Arrays.sort(intervals, (int[] a, int[] b)->{return Integer.compare(a[0], b[0]);});
        

        int min=intervals[0][0];
        int max=intervals[0][1];
        int n=intervals.length;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=1; i<n; i++) {
            
            if(intervals[i][0]>max) {
                List<Integer> temp=new ArrayList<>();
                temp.add(min);
                temp.add(max);
                
                min=intervals[i][0];
                max=intervals[i][1];
                list.add(temp);
            } else if(inContact(min, max, intervals[i][0], intervals[i][1])) {
                max=Math.max(max, intervals[i][1]);
                min=Math.min(min, intervals[i][0]);
            }
            if(i==n-1) {
                List<Integer> temp=new ArrayList<>();
                temp.add(min);
                temp.add(max);
                list.add(temp);
            }
        }
        if(list.size()==0) {
            List<Integer> temp=new ArrayList<>();
            temp.add(min);
            temp.add(max);
            list.add(temp);
        }
        n=list.size();
        int[][] res = new int[n][2];
        for(int i=0; i<n; i++) {
            res[i][0]=list.get(i).get(0);
            res[i][1]=list.get(i).get(1);
        }

        return res;
    }
}