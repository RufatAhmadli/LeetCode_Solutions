package Medium.HashMap;

import java.util.*;

public class Question890 {
    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        System.out.println(findAndReplacePattern(words, pattern));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        String normalizedPattern = normalize(pattern);
        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (normalize(word).equals(normalizedPattern)) {
                res.add(word);
            }
        }
        return res;
    }

    private static String normalize(String word) {
        Map<Character, Integer> mp = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (char c : word.toCharArray()) {
            mp.putIfAbsent(c, index++);
            sb.append(mp.get(c));
        }
        return sb.toString();
    }
}
