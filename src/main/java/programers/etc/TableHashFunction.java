package programers.etc;

import java.util.Arrays;

/**
 * 테이블 해시 함수
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/147354
 */
public class TableHashFunction {

    public int solution(int[][] data, int col, int rowBegin, int rowEnd) {
        Arrays.sort(data, (d1, d2) -> {
            if (d1[col - 1] == d2[col - 1]) {
                return d2[0] - d1[0];
            }
            return d1[col - 1] - d2[col - 1];
        });

        int[] si = new int[data.length];

        for (int i = rowBegin - 1; i < rowEnd; i++) {
            int idx = i + 1;
            for (int d : data[i]) {
                si[i] += (d % idx);
            }
        }


        int answer = si[rowBegin - 1];
        for (int i = rowBegin; i < rowEnd; i++) {
            answer ^= si[i];
        }

        return answer;
    }

}
