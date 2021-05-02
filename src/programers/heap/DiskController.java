package programers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {

    public static int solution(int[][] jobs) {
        int len = jobs.length;
        int answer = 0;
        int index = 0;
        int count = 0;
        int endTime = 0;

        // 요청시간 오름차순
        Arrays.sort(jobs, ((o1, o2) -> o1[0] - o2[0]));
        // 작업시간 오름차순
        PriorityQueue<int[]> disk = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));

        while (count < len) {
            while (index < len && endTime <= jobs[index][0]) {
                disk.offer(jobs[index++]);
            }

            if (disk.isEmpty()) {
                disk.offer(jobs[0]);
            } else {
                int[] tmp = disk.poll();
                count++;
                answer += endTime + tmp[1] - tmp[0];
                endTime += tmp[1];
            }
        }

        return answer / len;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    /**
     * jobs([요청시간, 작업시간])     return
     * [[0, 3], [1, 9], [2, 6]]	 9
     */
}
