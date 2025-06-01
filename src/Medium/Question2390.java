package Medium;

import java.util.Stack;

public class Question2390 {
    public static void main(String[] args) {
        Question2390 q = new Question2390();
        String s = "il**autonrd**cl**nh*up*afpizp****d*a****lst";
        System.out.println(q.removeStars(s));
        System.out.println(q.removeStars2(s));
        System.out.println(q.removeStars3(s));
    }

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String removeStars2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '*') {
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }
            sb.append(cur);
        }
        return sb.toString();
    }

    public String removeStars3(String s) {
        var arr = s.toCharArray();
        int offset = 0;
        for (int i = 0 ; i < arr.length; ++i){
            var c = arr[i];
            if (c == '*') offset--;
            else {
                arr[offset] = c;
                offset++;
            }
        }

        return new String(arr, 0, offset);
    }
}

