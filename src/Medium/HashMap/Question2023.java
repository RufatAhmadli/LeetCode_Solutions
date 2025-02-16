package Medium.HashMap;

import java.util.*;

public class Question2023 {
    public static void main(String[] args) {
        String[] nums = {"777", "7", "77", "77"};
        String target = "7777";

        System.out.println(numOfPairs(nums, target));
    }

    public static int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : nums) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int n = target.length();
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            String left = target.substring(0, i + 1);
            String right = target.substring(i + 1);

            if (map.containsKey(left) && map.containsKey(right)) {
                if (left.equals(right)) {
                    count += map.get(left) * (map.get(left) - 1);
                } else {
                    count += map.get(left) * map.get(right);
                }
            }
        }
        return count;
    }
}
