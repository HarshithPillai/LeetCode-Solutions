class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> q = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        int count=0;

        for(int i=0; i<s.length(); i++) {
            Character ch = s.charAt(i);
            if(set.contains(ch)) {
                //queue ke front se keep on polling and deleting the popped element from set and once you reach 'ch' just pop and add it to the front;
                while(set.contains(ch)) {
                    Character front = q.poll();
                    set.remove(front);
                }
            }
            set.add(ch);
            q.add(ch);
            count=Math.max(count, set.size());
        }

        return count;
    }
}
