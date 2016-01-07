/*
  Sort first, then merge.
*/

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<Interval>();
        int l = intervals.size();
        if (l == 0) return result;

        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        };
        Collections.sort(intervals, comparator);

        Interval first = intervals.get(0);
        result.add(first);

        for (int i=1; i<l; i++){
            Interval last = result.get(result.size()-1);
            Interval temp = intervals.get(i);

            if (temp.start > last.end) result.add(temp);
            else if (temp.end > last.end) last.end = temp.end;
        }

        return result;
    }
}
