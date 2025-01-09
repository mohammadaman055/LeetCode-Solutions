class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        int count=0;
        for(int i=0;i<words.size();i++){
            string prefix=words[i].substr(0,pref.length());
            if(prefix==pref) count++;
        }
        return count;
    }
};