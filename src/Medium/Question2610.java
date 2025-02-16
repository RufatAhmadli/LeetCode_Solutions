package Medium;

import java.util.ArrayList;
import java.util.List;

public class Question2610 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 1, 2, 3, 1};
        System.out.println(findMatrix(nums));
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());


        for (int num : nums) {
            for (int ind = 0; ind < res.size(); ind++) {
                if (!res.get(ind).contains(num)) {
                    res.get(ind).add(num);
                    break;
                } else {
                    res.add(new ArrayList<>());
                }
            }
        }
        res.removeIf(List::isEmpty);
        return res;
    }
}

