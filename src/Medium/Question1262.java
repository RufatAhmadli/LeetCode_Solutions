package Medium;

//72.36%
public class Question1262 {
    public static void main(String[] args) {
        int[] nums = {3, 6, 5, 1, 8};
        System.out.println(maxSumDivThree(nums));
    }

    public static int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];

        for (int num : nums) {
            int[] temp = dp.clone();
            for (int i = 0; i < 3; i++) {
                int index = (temp[i] + num) % 3;
                dp[index] = Math.max(temp[i] + num, dp[index]);
            }
        }
        return dp[0];
    }


}

