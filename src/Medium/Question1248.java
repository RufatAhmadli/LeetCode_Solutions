package Medium;

import java.util.ArrayList;
import java.util.List;

public class Question1248 {
    public static void main(String[] args) {
        int[] nums = {91473, 45388, 24720, 35841, 29648, 77363, 86290, 58032, 53752, 87188, 34428, 85343, 19801, 73201};
        int k = 4;
        System.out.println(numberOfSubarrays(nums, k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                list.add(i);
            }
        }

        if (list.size() < k) return 0;
        int count = 0;
        for (int i = 1; i < list.size() - k; i++) {
            count += (n - list.get(i + k)) * list.get(i);
        }
        return count;
    }
}
