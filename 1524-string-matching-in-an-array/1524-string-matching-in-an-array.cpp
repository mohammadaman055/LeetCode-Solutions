class Solution {
public:
    vector<string> stringMatching(vector<string>& words) {
        vector<string> result;
        int n =words.size();
        for(int i=0;i<n;i++){
            string word = words[i];

            for(int j=0;j<n;j++){
                if(i!=j){
                    int found=words[j].find(word);
                    if(found!= string::npos){
                        result.push_back(word);
                        break;
                    }
                }
            }
        }

        return result;
    }
};