
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);
        
        int xLeft = Math.max(A, E);
        int xRight = Math.min(C, G);
        int yUpper = Math.min(D, H);
        int yDown = Math.max(B, F);
        int overlap = 0;
        
        if( xRight >= xLeft && yUpper >= yDown )
            overlap = (xRight - xLeft) * (yUpper - yDown);

        return areaA + areaB - overlap;
        
    }
}
