//  Bug fixed;
import java.util.*;

public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length < 1)
            return 0;

        int n = ratings.length;

        int count = 1;

        int decreaseStart = 0;
        boolean isIncrease = true;
        boolean isContinue = false;
        int prev = 1;

        for(int i = 1; i < n; i++){
            
            if(ratings[i] == ratings[i - 1]){
                isIncrease = true;
                count++;

                isContinue = false;
                prev = 1;
            }
            
            else if(isIncrease){
                if(ratings[i] > ratings[i - 1])
                    count += ++prev;
                else{
                    isIncrease = false;
                    count++;
                    if(prev > 2)
                        decreaseStart = i;
                    else if(prev == 2){
                        isContinue = true;
                        decreaseStart = i - 1;
                    }
                    else {
                        isContinue = true;
                        decreaseStart = i - 1;
                        count++;
                    }
                }

            } else {
                if(ratings[i] < ratings[i - 1]){

                    count += i - decreaseStart + 1;

                        if(!isContinue && i - decreaseStart + 2 == prev){
                            isContinue = true;
                            decreaseStart--;
                        }
                } else {
                    isContinue = false;
                    isIncrease = true;
    
                    prev = 2;
                    count += prev;
                }   
            }
        }

        return count;
    }
}



//  Some bugs;
//  Misunderstand the purpose;
//  Same ratings does not necessarily have to get same candy;

import java.util.*;

public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length < 1)
            return 0;

        int n = ratings.length;
        
        int count = 1;
        
        int decreaseStart = 0;
        boolean isIncrease = true;
        boolean isContinue = false;
        int prev = 1;
        
        for(int i = 1; i < n; i++)
            if(isIncrease){
                if(ratings[i] == ratings[i - 1])
                    count += prev;
                else if(ratings[i] > ratings[i - 1])
                    count += ++prev;
                else{
                    isIncrease = false;
                    count++;
                    if(prev > 2)
                        decreaseStart = i;
                    else if(prev == 2){
                        isContinue = true;
                        decreaseStart = i - 1;
                    }
                    else {
                        isContinue = true;
                        decreaseStart = i - 1;
                        count++;
                    }
                }
                
            } else {
                if(ratings[i] == ratings[i - 1])
                    count++;
                else if(ratings[i] < ratings[i - 1]){
                    if(isContinue)
                        count += i - decreaseStart + 1;
                    else{
                        if(i - decreaseStart + 2 == prev){
                            isContinue = true;
                            decreaseStart--;
                        }
                        
                        count += i - decreaseStart;
                    }
                } else {
                    isContinue = false;
                    isIncrease = true;
                    
                    prev = 2;
                    count += prev;
                }
            }
        
        return count;
    }
}
