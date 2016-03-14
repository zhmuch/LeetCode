/*
    Other`s Work More Quick.
    Pay Attention to StringBuilder();
*/
public String convert(String s, int numRows) {
	if (numRows == 1)
		return s;
 
	StringBuilder sb = new StringBuilder();
	// step
	int step = 2 * numRows - 2;
 
	for (int i = 0; i < numRows; i++) {
		//first & last rows
		if (i == 0 || i == numRows - 1) {
			for (int j = i; j < s.length(); j = j + step) {
				sb.append(s.charAt(j));
			}
		//middle rows	
		} else {
			int j = i;
			boolean flag = true;
			int step1 = 2 * (numRows - 1 - i);
			int step2 = step - step1;
 
			while (j < s.length()) {
				sb.append(s.charAt(j));
				if (flag)
					j = j + step1;
				else
					j = j + step2;
				flag = !flag;
			}
		}
	}
 
	return sb.toString();
}

/*
    Self.
*/


public class Solution {
    public String convert(String s, int numRows) {
        int l = s.length();
        String res = "";
        int sum = (numRows - 1) * 2;
        if(numRows < 2)
            return s;
            
        int j = 0;
        while(j < l){
            res = res + s.charAt(j);
            j += sum;
        }

        for(int i=1; i<numRows-1; i++){
            boolean t = true;
            int k = i;
            int d1 = sum - 2 * i;
            int d2 = 2 * i;

            while(k < l){
                res = res + s.charAt(k);
                if(t)
                    k += d1;
                else
                    k += d2;
                t = !t;
            }
        }

        j = numRows - 1;
        while(j < l){
            res = res + s.charAt(j);
            j += sum;
        }

        return res;
    }
}
