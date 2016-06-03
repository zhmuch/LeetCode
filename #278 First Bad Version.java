//  Be careful with (left + right) / 2;
//  May cause int overflow;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while(left < right){
            int med = left + (right - left) / 2;
            if(isBadVersion(med))
                right = med;
            else
                left = med + 1;
        }
        return right;
    }
}
