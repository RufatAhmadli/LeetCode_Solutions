package Easy;

public class Question14 {
    public static void main(String[] args) {
        Question14 q = new Question14();
        String[] strings = new String[]{"flower", "flow", "flight"};
        System.out.println(q.longestCommonPrefix(strings));

    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return prefix.toString();
        }

        int ind = 0;
        while (true) {

            if (ind >= strs[0].length()) {
                break;
            }

            char ch = strs[0].charAt(ind);
            boolean flag = true;

            for (int i = 1; i < strs.length; i++) {
                if (ind >= strs[i].length() || strs[i].charAt(ind) != ch) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                prefix.append(ch);
                ind++;
            } else {
                break;
            }
        }
        return prefix.toString();
    }
}
