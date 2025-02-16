package Medium;

import java.util.ArrayList;
import java.util.List;

public class Question2125 {
    public static void main(String[] args) {
        String[] bank = {"011001", "000000", "010100", "001000"};
        System.out.println(numberOfBeams(bank));
    }

    public static int numberOfBeams(String[] bank) {
        int n = bank.length;
        int[] number = new int[n];
        int ind = 0;
        for (String str : bank) {
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') count++;
            }
            number[ind++] = count;
        }
        int res = 0;
        int i = 0;
        while (true) {
            while (i < n && number[i] == 0) i++;
            int j = i + 1;
            while (j < n && number[j] == 0) j++;
            if (i >= n || j >= n) break;
            res += number[i] * number[j];
            i = j;
        }
        return res;
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        boolean isValid = false;
        int start = -1;
        int end = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) == -1) continue;
            if (!isValid && words[i].indexOf(x) != -1){
                start = i;
                res.add(start);
                isValid = true;
            } else if (words[i].indexOf(x) != -1) {
                end = i;
                res.add(end);
            }
        }
        return res;
    }
}
