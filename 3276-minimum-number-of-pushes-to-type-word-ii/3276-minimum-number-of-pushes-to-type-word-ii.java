class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] arr = word.toCharArray();
        for(char ch:arr) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)->Integer.compare(b.getValue(), a.getValue()));
        for(Map.Entry<Character, Integer> entry:freq.entrySet()) {
            pq.add(entry);
            // System.out.println(entry.getKey()+" "+entry.getValue());
        }
        int ans = 0, i=0;
        while(!pq.isEmpty()) {
            int level = i/8;
            Map.Entry<Character, Integer> entry = pq.poll();
            // System.out.println(entry.getKey()+" "+entry.getValue());
            int count = entry.getValue();
            ans += count*(level+1);
            i++;
        }
        return ans;
    }
}