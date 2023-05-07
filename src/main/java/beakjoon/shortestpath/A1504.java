package beakjoon.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 특정한 최단 경로
public class A1504 {

    static class Node {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

    }

    static int n, e, v1, v2;
    static int[] dist;
    static ArrayList<Node>[] list;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

    }

    static int dijkstra(int start, int end) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visit = new boolean[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>((q1, q2) -> q1.weight - q2.weight);
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

//            if (dist[node.idx] != node.weight) continue;
            if (visit[node.idx]) continue;
            visit[node.idx] = true;

            for (Node next : list[node.idx]) {
                if (dist[node.idx] + next.weight >= dist[next.idx]) continue;
                if (visit[next.idx]) continue;

                dist[next.idx] = dist[node.idx] + next.weight;
                pq.offer(new Node(next.idx, dist[next.idx]));
            }
        }
        return dist[end];
    }

    static void process() {
        long path1 = dijkstra(1, v1);
        path1 += dijkstra(v1, v2);
        path1 += dijkstra(v2, n);

        long path2 = dijkstra(1, v2);
        path2 += dijkstra(v2, v1);
        path2 += dijkstra(v1, n);

        System.out.println("path1 = " + path1);
        System.out.println("path2 = " + path2);

        long result = Math.min(path1, path2);
        if (path1 >= Integer.MAX_VALUE && path2 >= Integer.MAX_VALUE)
            result = -1;

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

}
/*
7 7
1 2 3
3 2 5
1 3 1
6 5 3
7 5 8
5 4 2
6 4 3
2 6

3 3
1 3 20
1 2 15
2 3 6
1 3

4 5
1 2 3
1 3 1
1 4 1
2 3 3
3 4 4
2 3
답: 8
*/