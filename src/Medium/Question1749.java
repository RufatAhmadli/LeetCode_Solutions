package Medium;

public class Question1749 {
    public static void main(String[] args) {
        int[] nums = {1, -3, 2, 3, -4};
        System.out.println(maxAbsoluteSum(nums));
    }

    public static int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int maxAbsolute = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(sum) <= Math.abs(sum + nums[i])) {
                sum = sum + nums[i];
            } else {
                maxAbsolute = Math.max(maxAbsolute, sum);
            }
        }
        return maxAbsolute;
    }
}
