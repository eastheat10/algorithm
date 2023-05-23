package programers.etc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 두 큐 합 같게 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 */
public class Make2QueueSumSame {

    public int solution(int[] queue1, int[] queue2) {

        long sum1 = 0;
        long sum2 = 0;
        long total = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];

            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        total = sum1 + sum2;

        if (total % 2 == 1) {
            return -1;
        }
        total /= 2;
        int limit = queue1.length * 2;
        int p1 = 0;
        int p2 = 0;

        while (p1 < limit && p2 < limit) {
            if (sum1 == total) {
                return p1 + p2;
            }

            if (sum1 > total) {
                int tmp = q1.poll();
                sum1 -= tmp;
                sum2 += tmp;
                q2.offer(tmp);
                p2++;
            } else {
                int tmp = q2.poll();
                sum2 -= tmp;
                sum1 += tmp;
                q1.offer(tmp);
                p1++;
            }
        }

        return -1;
    }

}
