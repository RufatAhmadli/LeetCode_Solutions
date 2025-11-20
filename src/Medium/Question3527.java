package Medium;

import java.util.*;

public class Question3527 {
    public static void main(String[] args) {
        List<List<String>> responses = List.of(
                List.of("good", "ok", "good", "ok"),
                List.of("ok", "bad", "good", "ok", "ok"),
                List.of("good"),
                List.of("bad")
        );
        System.out.println(findCommonResponse(responses));
    }

    public static String findCommonResponse(List<List<String>> responses) {
        HashMap<String, Integer> map = new HashMap<>();
        for (List<String> r : responses) {
            Set<String> duplicateCheck = new HashSet<>();
            for (String s : r) {
                if (!duplicateCheck.contains(s)) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                }
                duplicateCheck.add(s);
            }
        }

        return map.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry<String, Integer>::getValue)
                        .thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder())))
                .map(Map.Entry::getKey)
                .orElse("");
    }
}