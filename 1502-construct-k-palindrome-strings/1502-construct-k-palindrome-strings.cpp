class Solution {
public:
    bool canConstruct(string s, int k) {
        int n = s.length(), count = 0;
        if(n == k) return true;
        if(n < k) return false;

        int mp[26] = {0};
        for(int i=0; i<n; i++) {
            mp[s[i]-'a']++;
        }
        for(int i=0; i<26; i++) {
            if(mp[i] & 1 == 1) {
                count++;
            }

        }
        if(count > k) return false;
        return true;
    }
};