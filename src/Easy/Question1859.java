package Easy;

public class Question1859 {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }

    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        int n = words.length;
        int[] indexes = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int m = words[i].length();
            int index = (int) words[i].charAt(m - 1) - 49;
            indexes[i] = index;
        }
        String[] newArray = new String[n];
        for (int i = 0; i < n; i++) {
            newArray[indexes[i]] = words[i];
        }
        for (String str : newArray) {
            int len = str.length() - 1;
            sb.append(str, 0, len);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
