package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question1207 {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : arr) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer val : mp.values()) {
            if (list.contains(val)) return false;
            list.add(val);
        }
        return true;
    }
}
