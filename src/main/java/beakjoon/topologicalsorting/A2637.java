package beakjoon.topologicalsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;
import java.util.StringTokenizer;

// 장난감 조립
public class A2637 {

    static class Node {
        int idx, val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    static int n, m;
    static int[] indeg, need;
    static boolean[] base;
    static ArrayList<Node> list[];
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        indeg = new int[n + 1];
        need = new int[n + 1];
        base = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
            base[i] = true;
        }

        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            indeg[y]++;
            list[x].add(new Node(y, k));
            base[x] = false;
        }
    }

    static void bfs() {
        Deque<Integer> q = new LinkedList<>();
        q.offer(n);
        need[n] = 1;

        while(!q.isEmpty()) {
            int x = q.poll();

            for (Node node : list[x]) {
                indeg[node.idx]--;
                need[node.idx] += (need[x] * node.val);

                if (indeg[node.idx] == 0) {
                    q.offer(node.idx);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (base[i]) {
                sb.append(i).append(" ").append(need[i]).append('\n');
            }
        }
    }

    static void process() {
        bfs();
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}