package programers.etc;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 요격 시스템
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/181188
 */
public class InterceptionSystem {

    public int solution(int[][] targets) {

        Arrays.sort(targets, Comparator.comparingInt(t -> t[1]));

        int l = targets[0][1];
        int cnt = 1;

        for (int i = 1; i < targets.length; i++) {
            int x = targets[i][0];
            if (l > x) {
                continue;
            }
            cnt++;
            l = targets[i][1];
        }

        return cnt;
    }

}
