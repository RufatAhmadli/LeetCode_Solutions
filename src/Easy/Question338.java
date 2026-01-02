package Easy;

import java.util.Arrays;

public class Question338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int power = 1;
        for (int i = 1; i <= n; i++) {
            if (i == power * 2) {
                power *= 2;
            }
            dp[i] = 1 + dp[i - power];
        }
        return dp;
    }
}
