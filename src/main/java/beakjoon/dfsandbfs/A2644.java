package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 촌수계산
public class A2644 {

    static int n, m, n1, n2;
    static ArrayList<Integer>[] list;
    static int[] cnt;
    static boolean[] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        cnt = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n1);
        visit[n1] = true;

        boolean find = false;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (Integer i : list[x]) {
                if (visit[i]) continue;
                cnt[i] = cnt[x] + 1;
                if (i == n2) {
                    find = true;
                    break;
                }
                q.offer(i);
                visit[i] = true;
            }
            if (find) {
                break;
            }
        }
    }

    static void process() {
        bfs();

        int result = cnt[n2];
        if (result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(cnt[n2]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
