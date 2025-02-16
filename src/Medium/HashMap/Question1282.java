package Medium.HashMap;

import java.util.ArrayList;
import java.util.List;

public class Question1282 {
    public static void main(String[] args) {
        int[]arr={2,2,1,1,1,1,1,1};
        System.out.println(groupThePeople(arr));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        boolean[] con = new boolean[n];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            if (!con[i]) {
                con[i] = true;
            }else{
                continue;
            }
            for (int j = i + 1; j < groupSizes.length; j++) {
                if (list.size() == groupSizes[i]) break;
                if (groupSizes[i] == groupSizes[j] && !con[j]) {
                    con[j] = true;
                    list.add(j);
                }

            }
            result.add(list);
        }
        return result;
    }
}
