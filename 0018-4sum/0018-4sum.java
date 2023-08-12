class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        for(int i=0; i<n-3; i++) {
            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n-2;j++) {
                if(j>i+1 && arr[j]==arr[j-1]) continue;
                int k=j+1;
                int l=n-1;
                while(k<l) {
                    long total = arr[i];
                    total+=arr[j];
                    total+=arr[k];
                    total+=arr[l];

                    if(total==target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);temp.add(arr[j]);
                        temp.add(arr[k]);temp.add(arr[l]);
                        list.add(temp);
                        k++;l--;
                        //l--;
                    } else if(target>total) {
                        k++;
                    } else {
                        l--;
                    }
                    while(k<l && k>j+1 && arr[k]==arr[k-1]) k++;
                    while(l>0 && l<n-1 && arr[l]==arr[l+1]) l--;
                }
            }
        }
        return list;
    }
}