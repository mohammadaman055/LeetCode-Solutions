//my solution
class Solution {
public:
    int maxScore(string s) {
        int left=0;
        int right=1;
        int max=0;
        while(left<right && right<s.length()){
            int leftcount=0;
            for(int j=0;j<=left;j++){
                if(s[j]=='0'){
                    leftcount++;
                }
            }

            int rightcount=0;
            for(int k=right;k<s.length();k++){
                if(s[k]=='1'){
                    rightcount++;
                }
            }
            
            if(max<(leftcount+rightcount) ){
                max=leftcount+rightcount;
            }

            left++;
            right++;
        }

        return max;
    }
};