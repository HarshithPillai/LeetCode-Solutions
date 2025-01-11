class Solution {
public:
    bool canConstruct(string s, int k) {
        int n = s.length(), count = 0;
        if(n == k) return true;
        if(n < k) return false;

        map<char, int> mp;
        for(int i=0; i<n; i++) {
            mp[s[i]]++;
        }
        for(auto x:mp) {
            if(x.second % 2 == 1) {
                count++;
            }

        }
        if(count > k) return false;
        return true;
    }
};