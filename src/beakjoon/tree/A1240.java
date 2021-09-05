package beakjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 노드 사이의 거리
public class A1240 {

    static int n, m, result;
    static ArrayList<Node>[] list;
    static int[][] arr;
    static class Node {
        int to;
        int distance;

        public Node(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        arr = new int[m + 1][2];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list[x].add(new Node(y, z));
            list[y].add(new Node(x, z));

        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;
        }
    }

    static void dfs(int from, int to, int previousNode, int dist) {
        if (from == to) {
            result = dist;
            return;
        }
        for (Node node : list[from]) {
            if (node.to != previousNode) {
                dfs(node.to, to, from, dist + node.distance);
            }
        }
    }

    static void process() {124
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            result = 0;
            dfs(arr[i][0], arr[i][1], -1, 0);
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
