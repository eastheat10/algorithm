package programers.etc;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 호텔 대실
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/155651
 */
public class HotelRoom {

    public int solution(String[][] bookTime) {
        int[][] times = new int[bookTime.length][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < bookTime.length; i++) {
            times[i][0] = timeToInt(bookTime[i][0]);
            times[i][1] = timeToInt(bookTime[i][1]) + 10;
        }

        Arrays.sort(times, (t1, t2) -> {
            if (t1[0] == t2[0]) {
                return t1[1] - t2[1];
            }
            return t1[0] - t2[0];
        });


        for (int[] time : times) {
            if (pq.isEmpty()) {
                pq.offer(time[1]);
                continue;
            }

            if (pq.peek() <= time[0]) {
                pq.poll();
            }
            pq.add(time[1]);
        }

        return pq.size();
    }

    private int timeToInt(String t) {
        String[] s = t.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }

}
