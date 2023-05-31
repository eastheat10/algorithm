package programers.etc;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 보석 쇼핑
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/67258?language=java
 */
public class GemShopping {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        Collections.addAll(set, gems);

        int l = 0;
        int len = gems.length;
        int size = set.size();

        for (int r = 0; r < gems.length; r++) {
            map.put(gems[r], map.getOrDefault(gems[r], 0) + 1);

            while (map.get(gems[l]) > 1) {
                map.put(gems[l], map.get(gems[l++]) - 1);
            }

            if (map.size() == size && len > r - l) {
                len = r - l;
                answer[0] = l + 1;
                answer[1] = r + 1;
            }
        }

        return answer;
    }

}
