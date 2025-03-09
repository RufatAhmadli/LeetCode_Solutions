package Medium;

import java.util.*;

public class Question3016 {
    public static void main(String[] args) {
        String word = "aabbccddeeffgghhiiiiii";
        System.out.println(minimumPushes(word));
    }

    public static int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        list.sort(Collections.reverseOrder());
        int res = 0;
        int l = 1;
        for (int i = 0; i < list.size(); i++) {
            if (i % 8 == 0 && i > 0) l++;
            res += list.get(i) * l;
        }
        return res;
    }
}
