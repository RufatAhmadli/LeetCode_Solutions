package Easy;

import java.util.HashMap;
import java.util.Map;

public class Question415 {
    public static void main(String[] args) {
//        String s1 = "121";
//        String s2 = "1491";
//        System.out.println(addStrings(s1, s2));
        int[] nums = {4,1,3,3};
        System.out.println(countBadPairs(nums));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int n = num1.length();
        int m = num2.length();
        int ind = Math.abs(n - m);
        int remainder = 0;
        for (int i = n - 1; i >= ind; i--) {
            int num = Integer.parseInt(num1.substring(i, i + 1)) + Integer.parseInt(num2.substring(i, i + 1));
            sb.append(num % 10 + remainder);
            remainder = num / 10;
        }
        if (n > m) sb.append(Integer.parseInt(num1.substring(0, ind - 1)) + remainder);
        if (n < m) sb.append(Integer.parseInt(num2.substring(0, ind - 1)) + remainder);
        return sb.reverse().toString();
    }

    public static long countBadPairs(int[] nums) {
        Map<Integer, Integer> bag = new HashMap<>();
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += -1 + bag.merge(nums[i] - i, 1, Integer::sum);
        }
        long len = nums.length;
        return  len * (len - 1) / 2 - count;
    }
}
