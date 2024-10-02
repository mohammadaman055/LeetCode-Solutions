class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int i=0;
        while(chalk[i]<=k){
            k-=chalk[i];
            if(1+i>=chalk.length){
                i=0;
            }else{
                i++;
            }
        }
        return i;
    }
}