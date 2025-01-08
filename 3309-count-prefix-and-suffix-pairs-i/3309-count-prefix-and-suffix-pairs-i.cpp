class Solution {
public:
    bool isPrefixAndSuffix(string str1,string str2){
        int n = str1.length();
        int m = str2.length();

        if(n>m) return false;

        string prefix = str2.substr(0,n);
        string suffix = str2.substr(m-n,m);

        return prefix==str1 && suffix==str1;
    }
    int countPrefixSuffixPairs(vector<string>& words) {
        int count=0;
        for(int i=0;i<words.size()-1;i++){
            for(int j=i+1;j<words.size();j++){
                if(isPrefixAndSuffix(words[i],words[j])) count++;
            }
        }
        return count;
    }
};