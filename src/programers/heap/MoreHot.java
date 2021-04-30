package programers.heap;

import java.util.PriorityQueue;

// 더 맵게
public class MoreHot {

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> hot = new PriorityQueue<>();
        for (int i : scoville)
            hot.offer(i);

        while (hot.peek() <= K) {
            if (hot.size() == 1) {
                answer = -1;
                break;
            }
            Integer first = hot.poll();
            Integer second = hot.poll();
            Integer newScoville = first + (second * 2);
            answer++;
            hot.offer(newScoville);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    /**
     * scoville	            K	return
     * [1, 2, 3, 9, 10, 12]	7	2
     */

}
