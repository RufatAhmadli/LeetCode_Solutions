package Easy;

public class Question3512 {
    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 2, 1};
        System.out.println(minOperations(nums, 3));
    }

    public static int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;
    }
}
