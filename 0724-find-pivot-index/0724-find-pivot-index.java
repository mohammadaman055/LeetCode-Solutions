class Solution {
    public int pivotIndex(int[] nums) {

        for(int i=0;i<nums.length;i++){
            if(sum(0,i,nums)==sum(i,nums.length-1,nums)){
                return i;
            }
        }

        return -1;
    }

    public int sum(int start,int end,int[] nums){
        int sum=0;
        for(int i=start;i<=end;i++){
            sum+=nums[i];
        }
        return sum;
    }
}