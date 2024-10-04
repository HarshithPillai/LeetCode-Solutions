class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        long freq[] = new long[2001], sum = 0, count = 0;
        for(int i:skill) {
            freq[i]++;
            sum += i;
        }
        // if(sum%2 != 0) return -1;
        int target = (int)sum * 2 / n;
        for(int i=1; i<=target/2; i++) {
            if(freq[i] != freq[target-i]) return -1l;
            if(i == target-i) count += (freq[i]/2) * (i * (target-i));
            else count += (freq[i]) * (i * (target-i));
        }
        return count;
    }
}