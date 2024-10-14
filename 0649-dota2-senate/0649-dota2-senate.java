class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> d = new LinkedList<>(), r = new LinkedList<>();
        char[] arr = senate.toCharArray();
        int n = arr.length;
        for(int i=0; i<n; i++) {
            char ch = arr[i];
            if(ch == 'R') {
                r.add(i);
            } else d.add(i);
        }
        while(!d.isEmpty() && !r.isEmpty()) {
            if(d.peek() < r.peek()) {
                d.add(d.poll()+n);
                r.poll();
            } else {
                r.add(r.poll()+n);
                d.poll();
            }
        }
        if(d.isEmpty()) return "Radiant";
        return "Dire";
    }
}