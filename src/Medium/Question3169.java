package Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question3169 {
    public static void main(String[] args) {
        int days = 10;
        int[][] meetings = {{5, 7}, {1, 3}, {9, 10}};
        System.out.println(countDays(days, meetings));
    }

    public static int countDays(int days, int[][] meetings) {
        Set<Integer> s = new HashSet<>();
        for (int[] meeting : meetings) {
            s.add(meeting[0]);
            s.add(meeting[1]);
        }
        List<Integer> l = s.stream().sorted().toList();
        int meetDays = 0;
        for (int i = 1; i < l.size(); i += 2) {
            meetDays += (l.get(i) - l.get(i - 1) + 1);
        }
        return days - meetDays;
    }
}
