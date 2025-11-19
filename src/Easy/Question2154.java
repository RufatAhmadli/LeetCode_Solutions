package Easy;

import java.util.HashSet;
import java.util.Set;

public class Question2154 {
    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 1, 12};
        int original = 3;
        System.out.println(findFinalValue(nums, original));
        System.out.println(findFinalValue2(nums, original));
    }

    public static int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (true) {
            if (set.contains(original)) original *= 2;
            else break;
        }
        return original;
    }

    public static int findFinalValue2(int[] nums, int original) {
        boolean x = true;
        while (x) {
            x = found(nums, original);
            original *= 2;
        }
        return original / 2;

    }

    public static boolean found(int[] nums, int var) {
        for (int ele : nums) {
            if (ele == var) {
                return true;
            }
        }
        return false;
    }
}
