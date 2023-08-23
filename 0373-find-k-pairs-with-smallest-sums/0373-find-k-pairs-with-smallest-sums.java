class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1=nums1.length;
        int n2=nums2.length;

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b)->Integer.compare(b.get(2),a.get(2)));
        int l=0,r=0;
        //List<Integer> temp = new ArrayList<>();
        int sum=0;
        // temp.add(l);temp.add(r);
        // temp.add(sum);

        // pq.add(temp);

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n1; i++) {
            for(int j=0; j<n2; j++) {
                sum=nums1[i]+nums2[j];
                if(pq.size()<k) {
                    List<Integer> t = new ArrayList<>();
                    t.add(i);t.add(j);
                    t.add(sum);
                    pq.add(t);
                } else if(sum<pq.peek().get(2)) {
                    pq.poll();
                    List<Integer> t = new ArrayList<>();
                    t.add(i);t.add(j);
                    t.add(sum);
                    pq.add(t);
                } else {
                    break;
                }
            }
        }
        while(!pq.isEmpty()) {
            k--;
            List<Integer> t=new ArrayList<>();
            List<Integer> top = pq.poll();
            t.add(nums1[top.get(0)]);
            t.add(nums2[top.get(1)]);
            result.add(t);
        }

        return result;

    }
}