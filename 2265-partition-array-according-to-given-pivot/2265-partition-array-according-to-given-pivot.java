class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lt = new ArrayList<>();
        List<Integer> gt = new ArrayList<>();
        int count = 0;
        for (int i : nums) {
            if (i > pivot) {
                gt.add(i);
            } else if (i < pivot) {
                lt.add(i);
            } else {
                count++;
            }
        }
        int n = lt.size() + gt.size() + count;
        while (count > 0) {
            count--;
            lt.add(pivot);
        }
        for(int i : gt) {
            lt.add(i);
        }
        return lt.stream().mapToInt(i -> i).toArray();
    }
}