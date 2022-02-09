package beakjoon.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A5719_거의최단경로 {
    static class Node implements Comparable<Node>{
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }
    final static int INF = Integer.MAX_VALUE;
    static int n, m, s, d;
    static int u, v, p;
    static int[] dist;
    static List<Node>[] map;
    static List<Integer>[] tracking;
    static boolean[][] isShortest;


    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true) {
            input();
            if (n == 0 && m == 0) break;
            process();
        }
        System.out.println(sb);
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (n == 0 && m == 0) return;

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new List[n];
        tracking = new List[n];
        isShortest = new boolean[n][n];
        dist = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            map[u].add(new Node(v, p));
        }
    }

    static void process() {
        dijkstra();
        if (dist[d] == INF) {
            sb.append(-1).append('\n');
            return;
        }
        block(d);
        dijkstra();
        print();
    }

    static void dijkstra() {
        for (int i = 0; i < n; i++) {
            dist[i] = INF;
            tracking[i] = new ArrayList<>();
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.to] < now.weight) continue;

            for (Node next : map[now.to]) {
                // 최단경로이면 pass
                if (isShortest[now.to][next.to]) continue;
                // 갱신이 안되면 pass
                if (dist[next.to] > dist[now.to] + next.weight) {
                    tracking[next.to].clear();
                    tracking[next.to].add(now.to);

                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
                // 최단경로라면 tracking list에 추가
                if (dist[next.to] == dist[now.to] + next.weight) {
                    tracking[next.to].add(now.to);
                }
            }
        }
    }

    static void block(int destination) {
        if (s == destination)
            return;

        for (int from : tracking[destination]) {
            if (!isShortest[from][destination]) {
                isShortest[from][destination] = true;
                block(from);
            }
        }
    }

    static void print() {
        if (dist[d] == INF) {
            sb.append(-1);
        } else {
            sb.append(dist[d]);
        }
        sb.append('\n');
    }
}
