package Medium.HashMap;

import java.util.*;

public class Question49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            List<Integer> freq = new ArrayList<>(Collections.nCopies(26,0));
            for (char c : chars) {
                freq.set(c - 'a', freq.get(c - 'a') + 1);
            }
            List<String> list = map.getOrDefault(freq, new ArrayList<>());
            list.add(str);
            map.put(freq, list);
        }
        return new ArrayList<>(map.values());
    }
}
