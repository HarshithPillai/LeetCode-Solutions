class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n=arr.length;
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> setList = new HashSet<>();
        Arrays.sort(arr);

        for(int i=0; i<n-2; i++) {
            Set<Integer> set = new HashSet<>();
            
            for(int j=i+1; j<n; j++) {
                int third = -(arr[i]+arr[j]);
                if(set.contains(third)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(third);
                    Collections.sort(temp);
                    setList.add(temp);
                    //System.out.println(temp);
                } 
                set.add(arr[j]);
                
            }
        }
        for(List<Integer> listTemp:setList) {
            list.add(listTemp);
        }
        return list;
        
    }
}