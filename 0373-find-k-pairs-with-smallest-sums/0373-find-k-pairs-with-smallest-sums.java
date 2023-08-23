class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((p1, p2) -> {
            return (nums1[p1.get(0)] + nums2[p1.get(1)]) - (nums1[p2.get(0)] + nums2[p2.get(1)]);
        });
        Set<List<Integer>> visited = new HashSet<>();
        List<Integer> initial = Arrays.asList(0, 0);
        pq.add(initial);
        visited.add(initial);
        while(!pq.isEmpty() && result.size() < k){
            List<Integer> pair = pq.poll();
            result.add(Arrays.asList(nums1[pair.get(0)], nums2[pair.get(1)]));
            int currentFirst = pair.get(0);
            int currentSecond = pair.get(1);
            if(currentFirst + 1 < nums1.length){
                List<Integer> next = Arrays.asList(currentFirst + 1, currentSecond);
                if(visited.add(next)){
                    pq.add(next);
                }
            }
            if(currentSecond + 1 < nums2.length){
                List<Integer> next = Arrays.asList(currentFirst, currentSecond + 1);
                if(visited.add(next)){
                    pq.add(next);
                }
            }
        }

        return result;
    }

    // private List<Integer> createPair(int first, int second)
    // {
    //     List<Integer> result = new ArrayList<>();
    //     result.add(first);
    //     result.add(second);
    //     return result;
    // }
}