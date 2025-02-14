class Solution {
    public int sumDigits(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int num:nums) {
            int val = sumDigits(num);
            if(!map.containsKey(val)) {
                List<Integer> pq = new ArrayList<>();
                pq.add(num);
                map.put(val, pq);
            } else {
                List<Integer> lt = map.get(val);
                Collections.sort(lt);
                if(lt.size() < 2) {
                    lt.add(num);
                } else if(lt.get(1) < num) {
                    lt.remove(0);
                    lt.add(num);
                } else if(lt.get(0) < num) {
                    lt.remove(0);
                    lt.add(num);
                }
                map.put(val, lt);
                // map.get(val).add(num);
            }
        }
        int max = -1;
        for(Map.Entry<Integer, List<Integer>> entry:map.entrySet()) {
            if(entry.getValue().size() > 1) {
                List<Integer> pq = entry.getValue();
                max = Math.max(max, pq.get(0) + pq.get(1));
            }
        }
        return max;
    }
}