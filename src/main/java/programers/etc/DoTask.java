package programers.etc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 과제 진행하기
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/176962?language=java
 */
public class DoTask {

    public String[] solution(String[][] plans) {

        PriorityQueue<Todo> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.start));
        List<String> answer = new ArrayList<>();
        LinkedList<Todo> stack = new LinkedList<>();

        for (String[] p : plans) {
            pq.offer(new Todo(p[0], p[1], p[2]));
        }

        while (!pq.isEmpty()) {
            Todo cur = pq.poll();
            int current = cur.start;

            if (pq.isEmpty()) {
                answer.add(cur.name);
                if (!stack.isEmpty()) {
                    while (!stack.isEmpty()) {
                        answer.add(stack.pop().name);
                    }
                }
                continue;
            }

            Todo next = pq.peek();

            if (current + cur.playtime < next.start) {
                answer.add(cur.name);
                current += cur.playtime;

                while (!stack.isEmpty()) {
                    Todo remain = stack.pop();

                    if (current + remain.playtime > next.start) {
                        remain.playtime -= (next.start - current);
                        stack.push(remain);
                        break;
                    }
                    current += remain.playtime;
                    answer.add(remain.name);
                }

            } else if (current + cur.playtime == next.start) {
                answer.add(cur.name);
            } else {
                cur.playtime -= (next.start - current);
                stack.push(cur);
            }
        }

        return answer.toArray(new String[0]);
    }

    static class Todo {

        String name;
        int start;
        int playtime;

        public Todo(String name, String start, String playtime) {
            this.name = name;
            this.start = convert(start);
            this.playtime = Integer.parseInt(playtime);
        }

        private static int convert(String time) {
            String[] t = time.split(":");
            return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
        }
    }

}
