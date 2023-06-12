package programers.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 배달
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/12978
 */
public class Delivery {

    private List<Node>[] map;
    private int[] dist;

    public int solution(int n, int[][] road, int k) {
        map = new List[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int[] r : road) {
            map[r[0]].add(new Node(r[1], r[2]));
            map[r[1]].add(new Node(r[0], r[2]));
        }

        find();

        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] <= k) {
                cnt++;
            }
        }

        return cnt;
    }

    private void find() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        pq.offer(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (dist[node.to] != node.weight) {
                continue;
            }

            for (Node next : map[node.to]) {
                if (dist[node.to] + next.weight >= dist[next.to]) {
                    continue;
                }

                dist[next.to] = dist[node.to] + next.weight;
                pq.offer(new Node(next.to, dist[next.to]));
            }
        }

    }

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

}
