package Easy;

public class Question1437 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1};
        System.out.println(kLengthApart(nums, 2));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        int len = nums.length;
        int prevOne = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                if (prevOne != -1 && i - prevOne <= k) return false;
                else prevOne = i;
            }
        }
        return true;
    }
}
