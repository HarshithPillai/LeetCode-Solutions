class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        int ans = 0;
        int maxn = 0;
        for(int num : nums) maxn = max(maxn, num);
        vector<int> freq(nums.size() + maxn + 1, 0);
        for(int num : nums) {
            freq[num]++;
        }
        int last = -1;
        for(int i = 0; i < freq.size(); i++) {
            // last = max(last, i);
            if(freq[i] == 0) {
                continue;
            }
            if(last >= i) {
                ans += (last - i + 1) * freq[i];
            }
            ans += ((freq[i] - 1) * freq[i]) / 2;
            if(last >= i) last = last + freq[i];
            else last = i + freq[i] - 1;
        }
        return ans;
    }
};