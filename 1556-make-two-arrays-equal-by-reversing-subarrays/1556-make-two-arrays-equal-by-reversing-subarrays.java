class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int v:arr) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        for(int v:target) {
            if(map.containsKey(v)) {
                int count = map.get(v);
                if(count==1) map.remove(v);
                else map.put(v, count-1);
            } else {
                return false;
            }
        }
        if(map.size()>0) return false;
        return true;
    }
}