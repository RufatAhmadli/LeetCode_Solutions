package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Question17 {
    public static void main(String[] args) {
        Question17 q = new Question17();
        System.out.println(q.letterCombinations("234"));
    }

    Map<Character, String> digitMapper = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz");
    //backtracking
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = digitMapper.get(digit);

        if (letters != null) {
            for (char letter : letters.toCharArray()) {
                current.append(letter);
                backtrack(result, current, digits, index + 1);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}
