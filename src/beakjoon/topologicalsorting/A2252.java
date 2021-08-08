package beakjoon.topologicalsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 줄 세우기
public class A2252 {

    static int n, m;
    static ArrayList<Integer>[] adj;
    static int[] indeg;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        indeg = new int[n + 1];

        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            indeg[y]++;
        }

    }

    static void sort() {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append(" ");
            for (Integer i : adj[x]) {
                indeg[i]--;
                if (indeg[i] == 0)
                    q.offer(i);
            }
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
    }
}
