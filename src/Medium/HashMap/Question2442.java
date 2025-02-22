package Medium.HashMap;

import java.util.HashSet;
import java.util.Set;

public class Question2442 {
    public static void main(String[] args) {
        int[] nums = {1, 13, 10, 12, 31};
        System.out.println(countDistinctIntegers(nums));
    }

    public static int countDistinctIntegers(int[] nums) {
        Set<Integer> pos = new HashSet<>();
        for (int num : nums) {
            pos.add(num);
            pos.add(reverse(num));
        }
        return pos.size();
    }

    public static int reverse(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }
}
