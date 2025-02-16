package Strings;

import java.util.Stack;

public class Question1901 {
    public static void main(String[] args) {
        String s = "eemckxmckx";
        String part = "emckx";
        System.out.println(removeOccurrences(s, part));
        System.out.println(removeOccurrences2(s, part));

    }

    public static String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            boolean con = false;
            int n = part.length();
            char c = s.charAt(i);
            stack.push(c);
            if (stack.size() < n) continue;
            int ind = stack.size() - 1;
            while (true) {
                if (!stack.get(ind).equals(part.charAt(n - 1))) {
                    break;
                }
                n--;
                ind--;
                if (n == 0) {
                    con = true;
                    break;
                }
            }
            if (con) {
                for (int j = 0; j < part.length(); j++) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static String removeOccurrences2(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int n = part.length();
        int m = s.length();
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            sb.append(c);
            if (sb.length() < n) continue;
            if (sb.substring(sb.length() - n).equals(part)) {
                for (int j = 0; j < n; j++) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }
    public String removeOccurrences3(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.indexOf(part) != -1) {
            int idx = sb.indexOf(part);
            sb.delete(idx, idx + part.length());
        }
        return sb.toString();
    }

}
