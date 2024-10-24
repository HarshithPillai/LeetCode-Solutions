class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
        for(int i:nums1) s1.add(i);
        for(int i:nums2) s2.add(i);
        List<List<Integer>> lt = new ArrayList<>();
        lt.add(new ArrayList<>());
        lt.add(new ArrayList<>());
        for(int i:s2) {
            if(!s1.contains(i)) lt.get(1).add(i);
        }
        for(int i:s1) {
            if(!s2.contains(i)) lt.get(0).add(i);
        }
        return lt;
    }
}