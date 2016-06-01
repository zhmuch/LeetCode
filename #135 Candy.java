//  Other`s better solution;
public class Solution {  
    public int candy(int[] ratings) {  
        int size = ratings.length;  
        if (size == 0) return -1;  
        if (size == 1) return 1;  
          
        int[] cans = new int[size];  
        cans[0] = 1;  
        //正向扫描一遍，如果右边的rating比左边高，那么右边的糖果数就比左边多一个，否则只给一个糖果  
        for (int i = 1; i < size; i++) {  
            if (ratings[i] > ratings[i - 1]) cans[i] = cans[i - 1] + 1;  
            else cans[i] = 1;  
        }  
        //反向扫描一遍，如果左边的rating比右边高，并且左边的糖果数比右边少，那么左边的糖果数应比右边多一  
        for (int i = size - 2; i >= 0; i--) {  
            if (ratings[i] > ratings[i + 1] && cans[i] <= cans[i + 1]) {  
                cans[i] = cans[i + 1] + 1;  
            }  
        }  
          
        int ret = 0;  
        for (int i = 0; i < size; i++) {  
            ret += cans[i];  
        }  
          
        return ret;  
    }  
}  

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
