package beakjoon.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최단경로
public class A1753 {

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        int idx;
        int dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int v, e, start;
    static Integer[] dist;
    static ArrayList<Edge>[] edges;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        dist = new Integer[v + 1];
        edges = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++)
            edges[i] = new ArrayList<>();

        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[from].add(new Edge(to, weight));
        }
    }

    static void dijkstra() {
        for (int i = 1; i <= v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        pq.offer(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (dist[info.idx] < info.dist) continue;

            for (Edge edge : edges[info.idx]) {
                if (dist[info.idx] + edge.weight >= dist[edge.to]) continue;
                dist[edge.to] = dist[info.idx] + edge.weight;
                pq.offer(new Info(edge.to, dist[edge.to]));
            }
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        dijkstra();
        print();
    }
}
