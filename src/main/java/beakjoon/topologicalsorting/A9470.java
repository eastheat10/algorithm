package beakjoon.topologicalsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Strahler 순서
public class A9470 {

    static int k, m, p;
    static ArrayList<Integer>[] lists;
    static int[] ind, order, level;
    static StringBuilder sb = new StringBuilder();

    static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        ind = new int[m + 1];
        order = new int[m + 1];
        level = new int[m + 1];
        lists = new ArrayList[m + 1];
        for (int i = 0; i <= m; i++)
            lists[i] = new ArrayList<>();

        for (int i = 1; i <= p; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            lists[x].add(y);
            ind[y]++;
        }
    }

    static void process(int t) {
        Deque<Integer> q = new LinkedList<>();

        for (int i = 1; i <= m; i++) {
            if (ind[i] == 0) {
                q.offer(i);
                order[i] = 1;
                level[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();

            if (level[x] >= 2)
                order[x]++;

            for (Integer i : lists[x]) {
                ind[i]--;

                if (ind[i] == 0) {
                    q.offer(i);
                }
                if (order[x] == order[i]) {
                    level[i]++;
                } else if (order[i] < order[x]) {
                    level[i] = 1;
                    order[i] = order[x];
                }
            }
        }

        sb.append(t).append(" ").append(order[m]).append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            input(br);
            process(t);
        }

        System.out.println(sb);
    }
}
