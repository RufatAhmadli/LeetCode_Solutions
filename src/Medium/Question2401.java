package Medium;

import java.util.Arrays;

public class Question2401 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 8, 48, 10};
        System.out.println(longestNiceSubarray(nums));
    }

    public static int longestNiceSubarray(int[] nums) {
        int[] freq = new int[32];
        for (int num : nums) {
            String binary = Integer.toBinaryString(num);
            int m = binary.length();
            for (int i = m - 1; i >= 0; i--) {
                freq[m - i - 1] += Integer.parseInt(binary.substring(i, i + 1), 2);
            }
        }
        int max = 0;
        for (int j : freq) {
            if (j > max) {
                max = j;
            }
        }
        return nums.length - max == 0 ? 1 : nums.length - max;
    }
}
