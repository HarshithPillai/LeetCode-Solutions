class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        for(int i:nums) if(i!=0) {
            flag = true;
            break;
        }
        if(!flag) return "0";
        List<String> arr = new ArrayList<>();
        for(int i = 0; i<n; i++) arr.add(nums[i]+"");
        Collections.sort(arr, (a,b) -> (b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        for(String s:arr) sb.append(s);
        return sb.toString();
        
    }
}