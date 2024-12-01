class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int countZero = 0;
        Arrays.sort(arr);
        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i]==0) countZero++;
            set.add(arr[i]);
            if(set.contains(arr[i]*2) && arr[i]!=0) return true;
        }
        for(int i=arr.length-1; i>=0; i--) {
            set.add(arr[i]);
            if(set.contains(arr[i]*2) && arr[i]!=0) return true;
        }
        if(countZero > 1) return true;
        return false;
    }
}