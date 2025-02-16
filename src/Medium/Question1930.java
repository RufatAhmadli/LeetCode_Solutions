package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1930 {
    public static void main(String[] args) {
        String s = "aabca";
        System.out.println(countPalindromicSubsequence(s));
    }

    public static int countPalindromicSubsequence(String s) {
        int count = 0;
        int n = s.length();


        for (char middle = 'a'; middle <= 'z'; middle++) {
            int leftIndex = -1;
            int rightIndex = -1;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == middle) {
                    if (leftIndex == -1) {
                        leftIndex = i;
                    }
                    rightIndex = i;
                }
            }


            if (leftIndex != -1 && rightIndex != -1 && rightIndex - leftIndex > 1) {
                boolean[] seen = new boolean[26];
                for (int i = leftIndex + 1; i < rightIndex; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                }


                for (boolean isSeen : seen) {
                    if (isSeen) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
