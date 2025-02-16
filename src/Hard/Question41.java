package Hard;

public class Question41 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num >= 1 && num <= nums.length) {
                if (nums[num - 1] > 0) {
                    nums[num - 1] *= -1;
                } else if (nums[num - 1] == 0) {
                    nums[num - 1] = -1 * (nums.length + 1);
                }
            }
        }
        for (int i = 1; i < nums.length + 1; i++) {
            if (nums[i - 1] >= 0) {
                return i;
            }
        }

        return nums.length + 1;
    }
}
