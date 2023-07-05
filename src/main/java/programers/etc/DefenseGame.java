package programers.etc;

import java.util.PriorityQueue;

/**
 * 디펜스 게임
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/142085
 */
public class DefenseGame {
    public int solution(int n, int k, int[] enemy) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < enemy.length; i++) {

            pq.offer(enemy[i]);

            if (k < pq.size()) {
                n -= pq.poll();
            }

            if (n < 0) {
                return i;
            }
        }

        return enemy.length;
    }
}
