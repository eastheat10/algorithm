package programers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {
    public static int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Integer> disk = new PriorityQueue<>();

        Arrays.sort(jobs, ((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        }));

        for (int[] job : jobs) {
            int length = job[1] - job[0];
            disk.offer(length);
        }
        int size = jobs.length;
        while (!disk.isEmpty()) {
            int poll = disk.poll();
            System.out.println("poll = " + poll);
            answer += answer + poll;
            System.out.println("answer = " + answer);
        }
        return answer / size;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    /**
     * jobs	                     return
     * [[0, 3], [1, 9], [2, 6]]	 9
     */
}
