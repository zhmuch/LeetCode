/*
  直接比较插入。
*/

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int s = intervals.size();
        List<Interval> result = new LinkedList<Interval>();
        if(s<1) {
            result.add(newInterval);
            return result;
        }
        boolean start = false;
        boolean end = false;
        boolean ever = false;

        for (int i=0; i<s; i++){

            Interval temp = intervals.get(i);
            if(end) {
                result.add(temp);
            }
            else if(start) {
                if(temp.start > newInterval.end){
                    result.add(temp);
                    end = true;
                }
                else if(temp.end >= newInterval.end){
                    result.get(result.size()-1).end = temp.end;
                    end = true;
                }
            }
            else{
                if (temp.start < newInterval.start) {
                    result.add(temp);
                    if (temp.end >= newInterval.start){
                        start = true;
                        ever = true;
                        if (newInterval.end <= temp.end){
                            end = true;
                        }
                        else {
                            result.get(result.size()-1).end = newInterval.end;
                        }
                    }
                }
                else{
                    result.add(newInterval);
                    start = true;
                    ever = true;
                    if(newInterval.end >= temp.start){
                        if(temp.end >= newInterval.end){
                            result.get(result.size()-1).end = temp.end;
                            end = true;
                        }
                    }
                    else {
                        result.add(temp);
                        end = true;
                    }
                }
            }
        }
        if(!ever) result.add(newInterval);
        return result;
    }
}
