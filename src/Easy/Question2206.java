package Easy;

public class Question2206 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 2, 2, 2};
        System.out.println(divideArray(nums));
    }

    public static boolean divideArray(int[] nums) {
        int[] freq = new int[501];
        for (int num : nums) {
            freq[num]++;
        }
        for (int num : nums) {
            if (freq[num] % 2 == 1) return false;
        }
        return true;
    }
}
