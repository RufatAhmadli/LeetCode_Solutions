package Medium;

public class Question712 {
    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("delete", "leet"));
    }

    public static int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int sum1 = 0;
        int sum2 = 0;
        for (char c : s1.toCharArray()) {
            sum1 += c;
        }
        for (char c : s2.toCharArray()) {
            sum2 += c;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = (int) s1.charAt(i - 1) + dp[i - 1][j - 1];
                } else {
                   dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return sum1 + sum2 - 2 * dp[n][m];

    }
}
