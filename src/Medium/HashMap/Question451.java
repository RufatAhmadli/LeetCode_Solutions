package Medium.HashMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Question451 {
    public static void main(String[] args) {
        String s1 = "tree";
        String s2 = "cccaaa";
        System.out.println(frequencySort(s1));
        System.out.println(frequencySort(s2));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (char c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> sorted = mp.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    int freqCompare = Integer.compare(entry2.getValue(), entry1.getValue());
                    return (freqCompare != 0) ? freqCompare : Character.compare(entry1.getKey(), entry2.getKey());
                })
                .toList();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sorted) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
