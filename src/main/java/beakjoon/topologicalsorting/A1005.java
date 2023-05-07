package beakjoon.topologicalsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// ACM CRAFT
public class A1005 {

    static int n, k, w;
    static ArrayList<Integer>[] adj;
    static int[] indeg, t, t_done;

    static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        indeg = new int[n + 1];
        t = new int[n + 1];
        t_done = new int[n + 1];

        adj = new ArrayList[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            t[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            indeg[y]++;
        }
        w = Integer.parseInt(br.readLine());
    }

    static void sort() {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
                t_done[i] = t[i];
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();

            for (Integer y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0)
                    q.offer(y);
                t_done[y] = Math.max(t_done[y], t_done[x] + t[y]);
            }

        }

        System.out.println(t_done[w]);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            input(br);
            sort();
        }
    }
}
