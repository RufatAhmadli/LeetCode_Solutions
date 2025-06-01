package Easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question1436 {
    public static void main(String[] args) {
        Question1436 q = new Question1436();
        List<List<String>> paths = List.of(
                List.of("London", "New York"),
                List.of("New York", "Lima"),
                List.of("Lima", "Sao Paulo")
        );
        System.out.println(q.destCity(paths));
    }

    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        String destCity = paths.getFirst().getFirst();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }

        while (true) {
            if (!map.containsKey(destCity)) {
                return destCity;
            }
            destCity = map.get(destCity);
        }
    }
}
