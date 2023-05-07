package beakjoon.shortestpath;

/**
 * K번째 최단 경로
 * https://www.acmicpc.net/problem/1854
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class A1854 {

    static class Edge implements Comparable<Edge> {
        int node, distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }

    static int n, m, k;
    static List<Edge>[] map;
    static PriorityQueue<Integer>[] distance;

    public static void main(String[] args) throws IOException {
        input();
        process();
        print();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        distance = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
            distance[i] = new PriorityQueue<>((i1, i2) -> i2 - i1);
        }

        int a, b, c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map[a].add(new Edge(b, c));
        }
    }

    static void process() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distance[1].offer(0);
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.distance > distance[now.node].peek()) continue;

            for (Edge next : map[now.node]) {
                if (distance[next.node].size() < k) {
                    distance[next.node].offer(now.distance + next.distance);
                    pq.offer(new Edge(next.node, now.distance + next.distance));
                } else if (distance[next.node].peek() > (now.distance + next.distance)) {
                    distance[next.node].poll();
                    distance[next.node].offer(now.distance + next.distance);
                    pq.offer(new Edge(next.node, now.distance + next.distance));
                }
            }
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (distance[i].size() == k) {
                sb.append(distance[i].peek()).append('\n');
            } else {
                sb.append(-1).append('\n');
            }
        }
        System.out.println(sb);
    }

}
