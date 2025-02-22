package Easy;

public class Question2367 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        System.out.println(arithmeticTriplets(arr, diff));
    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        int[] freq = new int[201];
        for (int num : nums) {
            freq[num]++;
        }
        int count = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            boolean con = true;
            for (int j = 1; j < 3; j++) {
                if (nums[i] + j * diff >= 201 || freq[nums[i] + j * diff] == 0) {
                    con = false;
                    break;
                }
            }
            if (con) count++;
        }
        return count;
    }
}
