package Easy;

public class Question2529 {
    public static void main(String[] args) {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2};
        System.out.println(maximumCount(nums));
    }

    public static int maximumCount(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int left1 = 0;
        int right1 = n - 1;
        while (left1 <= right1) {
            int mid = (left1 + right1) / 2;
            if (nums[mid] < 0) {
                left1 = mid + 1;
            } else {
                right1 = mid - 1;
            }
        }
        return Math.max(n - left, right1 + 1);
    }
}
