package Easy;

import java.util.HashSet;
import java.util.Set;

public class Question2716 {
    public static void main(String[] args) {
        String s1 = "aaabc";
        String s2 = "baadccab";
        System.out.println(minimizedStringLength(s1));
        System.out.println(minimizedStringLength(s2));
    }

    public static int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }
}
