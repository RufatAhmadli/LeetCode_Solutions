package Medium;

import java.util.Arrays;

public class Question1641 {
    public static void main(String[] args) {
        System.out.println(countVowelStrings(1));
        System.out.println(countVowelStrings(2));
        System.out.println(countVowelStrings(3));
    }

    public static int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    dp[j] += dp[k];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res += dp[i];
        }
        return res;
    }
}
