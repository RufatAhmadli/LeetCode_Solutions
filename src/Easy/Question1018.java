package Easy;

import java.util.ArrayList;
import java.util.List;

public class Question1018 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1};
        System.out.println(prefixesDivBy5(nums));
    }

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int prefix = 0;

        for (int num : nums) {
            prefix = (prefix * 2 + num) % 5;
            ans.add(prefix == 0);
        }

        return ans;
    }

}
