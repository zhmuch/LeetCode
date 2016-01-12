public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> row = new LinkedList<Integer>();
        if (rowIndex<0) return row;

        List<Integer> temp1 = new LinkedList<Integer>();
        temp1.add(1);
        result.add(temp1);

        for(int i=1; i<rowIndex+1; i++){
            List<Integer> temp = new LinkedList<Integer>();

            temp.add(1);
            temp.add(1);
            for(int j=1; j<i; j++) {
                temp.add(j, result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }
            result.add(temp);
        }
        return result.get(rowIndex);
    }
}
