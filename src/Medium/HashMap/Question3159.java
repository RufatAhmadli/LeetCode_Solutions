package Medium.HashMap;

import java.util.*;

public class Question3159 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 7};
        int[] queries = {1, 3, 2, 4};
        int x = 1;
        System.out.println(Arrays.toString(occurrencesOfElement(nums, queries, x)));
    }

    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                index.add(i);
            }
        }
        int n = queries.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        if (index.isEmpty()) return res;
        for (int i = 0; i < n; i++) {
            if (index.size() >= queries[i]) {
                res[i] = index.get(queries[i] - 1);
            }
        }
        return res;
    }
}
