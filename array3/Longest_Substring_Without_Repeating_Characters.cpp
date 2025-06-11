class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.length();
        int l = 0; 
        int r = 0;
        int len= 0;
        map<char, int> mpp;
        for(int i=0; i<n; i++){
            if(mpp.find(s[i]) != mpp.end()){
                l = max(mpp[s[r]] +1, l);
            }
            mpp[s[r]] = r;
            len = max(len, r-l+1);
            r++;
        }
        return len;
    }
};