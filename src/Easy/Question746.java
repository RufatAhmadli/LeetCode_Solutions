package Easy;

public class Question746 {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= n; i++) {
            int costValue = (i != n ? cost[i] : 0);
            dp[i] = Math.min(dp[i - 1] + costValue, dp[i - 2] + costValue);
        }
        return dp[n];
    }
}
