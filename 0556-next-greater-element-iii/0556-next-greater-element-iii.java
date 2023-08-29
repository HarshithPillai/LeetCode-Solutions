class Solution {
    public int nextGreaterElement(int n) {
        int temp=n;
        List<Integer> list = new ArrayList<>();
        while(temp>0) {
            list.add(temp%10);
            temp/=10;
        }
        Collections.reverse(list);
        int ind=-1;
        for(int i=list.size()-2; i>=0; i--) {
            if(list.get(i)<list.get(i+1)) {
                ind=i;
                break;
            }
        }
        if(ind==-1) return -1;
        int min=Integer.MAX_VALUE;
        int pivot=list.get(ind);
        int swapIndex=-1;
        for(int i=ind+1; i<list.size(); i++) {
            int ele=list.get(i);
            if(ele<min && ele>pivot) {
                min=ele;
                swapIndex=i;
            }
        }
        //swap pivot and this element
        list.set(ind, list.get(swapIndex));
        list.set(swapIndex, pivot);
        Collections.sort(list.subList(ind+1, list.size()));
        long ans=0;
        int exp=10;
        for(int num:list) {
            ans*=exp; ans+=num;
            if(ans>Integer.MAX_VALUE) return -1;
        }
        return (int)ans;
    }
}