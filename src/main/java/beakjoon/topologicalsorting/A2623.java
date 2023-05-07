package beakjoon.topologicalsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 음악 프로그램
public class A2623 {

    static int n, m;
    static ArrayList<Integer>[] adj;
    static int[] ind;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        ind = new int[n + 1];

        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = 0;
            for (int j = 1; j < cnt; j++) {
                y = Integer.parseInt(st.nextToken());
                adj[x].add(y);
                ind[y]++;
                x = y;
            }
        }
    }

    static void sort(){
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (ind[i] == 0)
                q.offer(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int x = q.poll();
            result.add(x);
            for (Integer i : adj[x]) {
                ind[i]--;
                if (ind[i] == 0)
                    q.offer(i);
            }
        }

        if (result.size() == n)
            for (int x : result)
                sb.append(x).append("\n");
        else
            sb.append(0);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
    }

}
