//  Linear;
//  Low Efficiency;


/**
 * Created by Muchen on 6/5/16.
 */
import java.util.*;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class SummaryRanges {

    List<Interval> list;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        this.list = new ArrayList<>();
    }

    public void addNum(int val) {
        
        // System.out.println("add: " + val);
        
        if(list.size() == 0){
            list.add(new Interval(val, val));
            return;
        }
        
        int idx = 0;
        while(idx < list.size()){
            if(list.get(idx).start <= val && list.get(idx).end >= val)
                return;
            if(list.get(idx).end < val)
                idx++;
            else
                break;
        }
        
        if(idx == list.size()){
            if(list.get(idx - 1).end == val - 1)
                list.get(idx - 1).end++;
            else
                list.add(new Interval(val, val));
            
            return;
        }
        
        if(idx == 0){
            if(list.get(idx).start - val == 1)
                list.get(idx).start--;
            else
                list.add(0, new Interval(val, val));
        } else {
            int left = idx - 1;
            int right = idx;
            
            // System.out.println("left: " + left);
            // System.out.println("right: " + right);
            // System.out.println("left end: " + list.get(left).end);
            // System.out.println("right start: " + list.get(right).start);
            
            if(list.get(left).end == val - 1 && list.get(right).start - val == 1){
                list.get(left).end = list.get(right).end;
                list.remove(right);
            } else if(list.get(left).end == val - 1){
                list.get(left).end++;
            } else if(list.get(right).start - val == 1){
                list.get(right).start--;
            } else {
                list.add(idx, new Interval(val, val));
            }
        }
    }

    public List<Interval> getIntervals() {
        return list;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
