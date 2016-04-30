//  Super Fast
public class Solution {
    public int findIndex(int buildingLeft,List<int[]> re,int StartIndex,int EndIndex){
        int mid;
        while(StartIndex<=EndIndex){
            mid=(StartIndex+EndIndex)/2;
            if(re.get(mid)[0]==buildingLeft){
                return mid;
            }
            else {
                if(re.get(mid)[0]<buildingLeft){
                    StartIndex=mid+1;
                }
                else{
                    EndIndex=mid-1;
                }
            }
        }
        return StartIndex-1;
    }

public int update(List<int[]> re,int index,long buildingLeft,int buildingRight,int buildingHeight){

    int newStart=index;

    for(int i=index;i<re.size();i++){
        if(i>0&&re.get(i)[1]==re.get(i-1)[1]){
            re.remove(i);
            i--;
            continue;
        }
        long thisEnd=(i==re.size()-1)?Long.MAX_VALUE:re.get(i+1)[0];
        int thisHeight=re.get(i)[1];
        if(buildingLeft>re.get(i)[0]){
            if(buildingHeight>re.get(i)[1]){
                int[] temp=new int[2];
                temp[0]=(int)buildingLeft;
                temp[1]=buildingHeight;
                re.add(i+1,temp);
                newStart=i+1;
                i++;
            }
        }
        else{
            if(buildingHeight>re.get(i)[1]){
                re.get(i)[1]=buildingHeight;
                if(i>0&&re.get(i-1)[1]==buildingHeight){
                    re.remove(i);
                if(newStart==i)
                    newStart--;
                i--;
                }
            }
        }

        if(buildingRight<thisEnd){
            if(buildingHeight>thisHeight){
            int[] temp=new int[2];
            temp[0]=buildingRight;
            temp[1]=thisHeight;
            re.add(i+1,temp);
            i++;
            }
            break;
        }
        else{
            if(buildingRight==thisEnd){
                break;
            }
            else{
                buildingLeft=thisEnd;
            }
        }
    }
    return newStart;
}


public List<int[]> getSkyline(int[][] buildings) {
    List<int[]> re=new ArrayList<>();
    if(buildings.length==0)
        return re;
    int[] temp=new int[2];
    temp[0]=Integer.MIN_VALUE;
    temp[1]=0;
    re.add(temp);
    int StartIndex=0;
    for(int i=0;i<buildings.length;i++){
        int buildingLeft=buildings[i][0];
        int buildingRight=buildings[i][1];
        int buildingHeight=buildings[i][2];
        int index=findIndex(buildingLeft,re,StartIndex,re.size()-1);
        StartIndex=update(re,index,buildingLeft,buildingRight,buildingHeight);
    }
    re.remove(0);
    return re;
}
}


//  Other`s work.
import java.util.*;

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        List<int[]> bl = new ArrayList<int[]>();
        for(int i=0; i<buildings.length; i++) {
            int[] b = buildings[i];
            bl.add(new int[]{b[0], b[2]});
            bl.add(new int[]{b[1], -b[2]});
        }

        Collections.sort(bl, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0]!=b[0]) return a[0] - b[0];
                else return b[1] - a[1];
            }
        });
        
        int pre = 0, cur = 0;
        for(int i=0; i<bl.size(); i++) {
            int[] b = bl.get(i);
            if(b[1]>0) {
                maxHeap.add(b[1]);
                cur = maxHeap.peek();
            } else {
                maxHeap.remove(-b[1]);
                cur = (maxHeap.peek()==null) ? 0 : maxHeap.peek();
            }
            if(cur!=pre) {
                res.add(new int[]{b[0], cur});
                pre = cur;
            }
        }
        return res;
    }
}
