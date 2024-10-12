class Solution {
    public int minNumberOfFrogs(String word) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('c', 0);
        map.put('r', 1);
        map.put('o', 2);
        map.put('a', 3);
        map.put('k', 4);
        int count = 0, max = 0;
        int[] total = new int[]{0,0,0,0,0};
        char[] charr = word.toCharArray();
        for(char ch:charr) {
            int ind = map.get(ch);
            if(ind == 0) {
                total[0]++;
                count++;
            } else if(ind == 4) {
                if(total[3] == 0) return -1;
                total[3]--;
                count--;
            } else {
                if(total[ind-1] == 0) return -1;
                total[ind-1]--;
                total[ind]++;
            }
            max = Math.max(max, count);
        }
        int sum = 0;
        for(int i:total) sum+=i;
        if(sum > 0) return -1;
        return max;
    }
}