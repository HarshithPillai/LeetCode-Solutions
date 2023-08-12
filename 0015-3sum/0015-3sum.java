class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n=arr.length;
        List<List<Integer>> list = new ArrayList<>();
        //Set<List<Integer>> setList = new HashSet<>();
        Arrays.sort(arr);
        int i=0, e=n-1;
        while(i<n-1) {
            e=n-1;
            int j=i+1;
            while(j<e) {
                while(j!=i+1 && j<e-1 &&  arr[j]==arr[j-1]) j++;
                while(e!=n-1 && e>0 && arr[e]==arr[e+1]) e--;  
                if(arr[i]+arr[j]+arr[e]==0 && j<e) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);temp.add(arr[j]);temp.add(arr[e]);
                    list.add(temp);
                    e--;
                } else if(arr[i]+arr[j]+arr[e]<0) {
                    j++;
                } else e--;
            }
            i++;
            while(i<n-1 && arr[i]==arr[i-1]) i++;
            
        }
        return list;
        
    }
}