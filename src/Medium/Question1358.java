package Medium;

import java.util.Arrays;

public class Question1358 {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }

    public static int numberOfSubstrings(String s) {
        int[] con = new int[3];
        Arrays.fill(con, -1);
        int ind = 0;
        int res = 0;
        while(ind < s.length()) {
            con[s.charAt(ind)- 'a'] = ind;
            if(con[0] != -1 && con[1] != -1  && con[2] != -1 ) {
                res = res + Math.min(con[0], Math.min(con[1], con[2])) +1;
            }
            ind++;
        }
        return res;
    }
}
