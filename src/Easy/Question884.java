package Easy;

import java.util.*;

public class Question884 {
    public static void main(String[] args) {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println(Arrays.toString(uncommonFromSentences(s1, s2)));
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        Map<String, Integer> mp = new HashMap<>();
        for (String s : words1) {
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }
        for (String s : words2) {
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }
        List<String> resList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            if (entry.getValue() == 1) { // Uncommon word
                resList.add(entry.getKey());
            }
        }
        return resList.toArray(new String[0]);
    }
}
