package Medium.HashMap;

import java.util.*;

public class Question2225 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        System.out.println(findWinners(nums));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        int[] lost = new int[100001];
        Set<Integer> unbeatableSet = new HashSet<>();
        Set<Integer> withOneLostSet = new HashSet<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            lost[loser]++;

            if (lost[winner] == 0) {
                unbeatableSet.add(winner);
            }

            unbeatableSet.remove(loser);

            if (lost[loser] == 1) {
                withOneLostSet.add(loser);
            } else if (lost[loser] > 1) {
                withOneLostSet.remove(loser);
            }
        }

        List<Integer> unbeatable = new ArrayList<>(unbeatableSet);
        List<Integer> withOneLost = new ArrayList<>(withOneLostSet);
        Collections.sort(unbeatable);
        Collections.sort(withOneLost);

        return Arrays.asList(unbeatable, withOneLost);
    }

}
