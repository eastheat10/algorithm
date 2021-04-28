package programers.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

// 프린터
public class Printer {
    public static int solution(int[] priorities, int location) {
        int len = priorities.length;
        int answer = 0;
        int[] priority = new int[10];
        int max = 0;
        Queue<Integer[]> print = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            Integer[] tmp = {i, priorities[i]};
            priority[priorities[i]]++;
            print.offer(tmp);
            max = Math.max(max, priorities[i]);
        }

        while (true) {
            if (print.peek()[1] != max) {
                print.add(print.poll());
            } else {
                Integer[] tmp = print.poll();
                answer++;
                if (tmp[0] == location) {
                    break;
                } else {
                    priority[max]--;
                }
            }
            if (priority[max] == 0)
                max = findMax(priority);
        }

        return answer;
    }

    public static int findMax(int[] arr) {
        int max = 0;
        for (int i = 9; i > 0; i--) {
            if (arr[i] > 0) {
                max = i;
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    /**
     * priorities	        location	return
     * [2, 1, 3, 2]	        2	        1
     * [1, 1, 9, 1, 1, 1]	0	        5
     */
}
