class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 == 1) return false;
        Stack<Integer> unlocked = new Stack<>(), count = new Stack<>();
        char[] arr = s.toCharArray(), lock = locked.toCharArray();
        for (int i = 0; i<n; i++) {
            if (lock[i] == '0') {
                unlocked.add(i);
            } else if (arr[i] == '(') {
                count.add(i);
            } else {
                if(count.isEmpty()) {
                    if(!unlocked .isEmpty()) {
                        unlocked.pop();
                    } else return false;
                } else {
                    count.pop();
                }
            }
        }
        while(!unlocked.isEmpty() && !count.isEmpty() && unlocked.peek() > count.peek()) {
            unlocked.pop();
            count.pop();
        }
        return count.isEmpty();
    }
}