package beakjoon.topologicalsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 게임 개발
public class A1516 {

    static int n;
    static ArrayList<Integer>[] lists;
    static int[] indeg, times, result;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        indeg = new int[n + 1];
        times = new int[n + 1];
        result = new int[n + 1];

        lists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            lists[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            times[i] = time;

            while (st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) break;
                lists[x].add(i);
                indeg[i]++;
            }
        }
    }

    static void process() {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
                result[i] = times[i];
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();

            for (Integer i : lists[x]) {
                indeg[i]--;
                result[i] = Math.max(result[x] + times[i], result[i]);

                if (indeg[i] == 0) {
                    q.offer(i);
                }

            }

        }

        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

}
