package Medium.HashMap;

import java.util.*;

public class Question720 {
    public static void main(String[] args) {
        String[] words = {"a","banana","app","appl","ap","apply","apple"};
        System.out.println(longestWord(words));
    }

    public static String longestWord(String[] words) {
        StringBuilder result = new StringBuilder();
        Set<String> set = new HashSet<>();
        Arrays.sort(words);
        for (String word : words) {
            boolean con = true;
            set.add(word);
            for (int i = 1; i < word.length(); i++) {
                if (!set.contains(word.substring(0, i))) {
                    con = false;
                    break;
                }
            }
            if (!con) continue;
            if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(String.valueOf(result)) < 0) ) {
                result = new StringBuilder(word);
            }
        }
        return result.toString();
    }
}
