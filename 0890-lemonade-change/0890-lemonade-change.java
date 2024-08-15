class Solution {
    public boolean lemonadeChange(int[] bills) {
        boolean result = true;
        int five = 0;
        int ten = 0;
        int twenty = 0;

        for(int i=0;i<bills.length;i++){
            if(bills[i]==5) five++;
            
            if(bills[i]==10){
                if(five!=0){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }
            
            if(bills[i]==20){
                if(ten>0 || five>0){
                    if(ten==0){
                        if(five>=3){
                            five-=3;
                            twenty++;
                        }else{
                            return false;
                        }
                    }else{
                        if(ten>0 && five>0){
                            ten--;
                            five--;
                            twenty++;
                        }else{
                            return false;
                        }
                    }
                }else{
                    return false;
                }   
            }
        }

        return result;
    }
}