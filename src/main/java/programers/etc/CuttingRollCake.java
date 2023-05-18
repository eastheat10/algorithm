package programers.etc;

import java.util.HashMap;
import java.util.Map;

/**
 * 롤케이크 자르기
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */
public class CuttingRollCake {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> chul = new HashMap<>();
        Map<Integer, Integer> bro = new HashMap<>();

        for (int t : topping) {
            chul.put(t, chul.getOrDefault(t, 0) + 1);
        }

        for (int t : topping) {
            int myTopping = chul.get(t);
            if (myTopping == 1) {
                chul.remove(t);
            } else {
                chul.put(t, myTopping - 1);
            }

            bro.put(t, bro.getOrDefault(t, 0) + 1);

            if (chul.size() == bro.size()) {
                answer++;
            }
        }

        return answer;
    }
}
