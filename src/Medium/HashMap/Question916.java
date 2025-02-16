package Medium.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question916 {
    public static void main(String[] args) {
        String[] words1={"leetcode"};
        String[] words2={"lcodeee","tcee","eode"};
        System.out.println(wordSubsets(words1,words2));
    }
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> universal = new ArrayList<>();

        // Step 1: Compute the maximum frequency map for words2
        Map<Character, Integer> maxFreqMap = new HashMap<>();
        for (String word : words2) {
            Map<Character, Integer> freqMap = mapCharacterCounts(word);
            for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
                char c = entry.getKey();
                int count = entry.getValue();
                maxFreqMap.put(c, Math.max(maxFreqMap.getOrDefault(c, 0), count));
            }
        }

        // Step 2: Check each word1 against the max frequency map
        for (String word : words1) {
            Map<Character, Integer> freqMap1 = mapCharacterCounts(word);
            boolean isUniversal = true;
            for (Map.Entry<Character, Integer> entry : maxFreqMap.entrySet()) {
                char c = entry.getKey();
                int requiredCount = entry.getValue();
                if (freqMap1.getOrDefault(c, 0) < requiredCount) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                universal.add(word);
            }
        }

        return universal;
    }

    private static Map<Character, Integer> mapCharacterCounts(String word) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }


}
