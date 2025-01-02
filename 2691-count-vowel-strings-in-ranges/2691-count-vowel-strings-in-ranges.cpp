// class Solution {
// public:
//     vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
//         vector<int> ans;

//         int words_n= words.size();
//         int m = queries.size();
//         int n = queries[0].size();

//         for(int i=0;i<m;i++){
//             int start = queries[i][0];
//             int end = queries[i][1];
//             int count=0;
            
//             for(int j=start;j<=end;j++){
//                 string word = words[j];
//                 if(word.length()>1){
//                     int l=word.length()-1;
//                     if((word[0]=='a'||word[0]=='e'||word[0]=='i'||word[0]=='o'||word[0]=='u') && (word[l]=='a'||word[l]=='e'||word[l]=='i'||word[l]=='o'||word[l]=='u')){
//                         count++;
//                     }
//                 }else{
//                     if(word[0]=='a'||word[0]=='e'||word[0]=='i'||word[0]=='o'||word[0]=='u'){
//                         count++;
//                     }
//                 }
//             }
            
//             ans.push_back(count);
//         }

//         return ans;
//     }
// };

class Solution {
public:
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        vector<int> ans;
        int words_n = words.size();
        
        // Preprocessing to mark the valid words
        vector<int> valid(words_n, 0);
        
        // Function to check if a character is a vowel
        auto isVowel = [](char c) -> bool {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        };
        
        // Preprocess words to determine which words start and end with vowels
        for (int i = 0; i < words_n; ++i) {
            string word = words[i];
            if (word.length() > 1) {
                int l = word.length() - 1;
                if (isVowel(word[0]) && isVowel(word[l])) {
                    valid[i] = 1;
                }
            } else {
                if (isVowel(word[0])) {
                    valid[i] = 1;
                }
            }
        }

        // Create a prefix sum array for valid words
        vector<int> prefixSum(words_n + 1, 0);
        for (int i = 1; i <= words_n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + valid[i - 1];
        }
        
        // Answer the queries using the prefix sum
        for (const auto& query : queries) {
            int start = query[0];
            int end = query[1];
            // Calculate the number of valid words in the range [start, end]
            ans.push_back(prefixSum[end + 1] - prefixSum[start]);
        }

        return ans;
    }
};
