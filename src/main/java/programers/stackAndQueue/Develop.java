package programers.stackAndQueue;

import java.util.*;

// 기능개발
public class Develop {

    public static int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        Queue<Integer> day = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int restProgress = 100 - progress;
            int need = restProgress % speed == 0 ? restProgress / speed : restProgress / speed + 1;
            day.offer(need);
        }

        ArrayList<Integer> countTask = new ArrayList<>();
        int tmp = day.poll();

        while (!day.isEmpty()) {
            int count = 1;
            while (!day.isEmpty() && day.peek() <= tmp) {
                day.poll();
                count++;
            }
            countTask.add(count);
            if(day.isEmpty())
                break;
            tmp = day.poll();
            if (day.size() == 0) {
                countTask.add(1);
                break;
            }
        }
        return countTask.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        for (int i : solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        for (int i : solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})) {
            System.out.print(i + " ");
        }
    }

    /**
     * progresses	            speeds	            return
     * [93, 30, 55]	            [1, 30, 5]	        [2, 1]
     * [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
     */
}
