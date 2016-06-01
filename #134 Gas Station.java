//  Naive Search;
//  TLE;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length != cost.length || gas.length < 1)
            return -1;

        int res = -1;
        
        for(int i = 0; i < gas.length; i++){
            int tank = 0;
            int idx = i;
            
            while(true) {
                tank += gas[idx] - cost[idx];
                if(tank < 0)
                    break;
                
                idx = (idx == gas.length - 1) ? 0 : idx + 1;
                if(idx == i){
                    return i;
                }
            }
        }
        
        return res;
    }
}

