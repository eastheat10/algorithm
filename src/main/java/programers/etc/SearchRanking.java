package programers.etc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchRanking {

    Map<String, List<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        int[] answer = new int[query.length];

        for (String i : info) {
            makeSentence(i.split(" "), "", 0);
        }

        map.values().forEach(Collections::sort);

        for (int i = 0; i < query.length; i++) {
            String s = query[i].replaceAll(" and ", "");
            String[] arr = s.split(" ");
            answer[i] = map.containsKey(arr[0]) ? search(arr[0], Integer.parseInt(arr[1])) : 0;
        }

        return answer;
    }

    private void makeSentence(String[] q, String s, int depth) {
        if (depth == 4) {
            map.computeIfAbsent(s, ignore -> new ArrayList<>());
            map.get(s).add(Integer.parseInt(q[4]));
            return;
        }

        makeSentence(q, s + q[depth], depth + 1);
        makeSentence(q, s + "-", depth + 1);
    }

    private int search(String key, int score) {
        List<Integer> list = map.get(key);
        int l = 0;
        int r = list.size() - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < score) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return list.size() - l;
    }

}