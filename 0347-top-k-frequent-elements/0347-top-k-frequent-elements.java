class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n=nums.length;
        for(int i=0; i<n; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i],1);
            } else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }

        ArrayList<Integer>[] freq = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) {
            freq[i] = new ArrayList<Integer>();
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int ind=0;
        for(int i=n; i>=0; i--) {
            for(int j=0; j<freq[i].size(); j++) {
                if(k==ind) return res;
                res[ind]=freq[i].get(j);
                ind++;
            }
        }

        return res;
    }
}