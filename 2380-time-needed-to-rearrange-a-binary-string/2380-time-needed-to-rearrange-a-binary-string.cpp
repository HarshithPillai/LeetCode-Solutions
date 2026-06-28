class Solution {
public:
    int secondsToRemoveOccurrences(string s) {
        int last1 = s.length()-1;
        int wait = 0, cnt0 = 0;
        while(last1 >=0 && s[last1] == '0') {
            last1--;
        }
        for(int i = 0; i <= last1; i++) {
            if(s[i] == '1' && i > 0 && s[i-1] == '1' && cnt0 > 0) {
                wait++;
            }
            if(s[i] == '0' && i > 0 && s[i-1] == '0' && wait > 0) {
                wait--;
            }
            if(s[i] == '0') cnt0++;
        }
        return wait + cnt0;
    } 
};