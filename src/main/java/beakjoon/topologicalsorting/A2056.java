package beakjoon.topologicalsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 작업
public class A2056 {

    static int n;
    static int[] indeg, times, result;
    static ArrayList<Integer> list[];

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        indeg = new int[n + 1];
        times = new int[n + 1];
        result = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());

            int task = Integer.parseInt(st.nextToken());
            while (task-- > 0) {
                int k = Integer.parseInt(st.nextToken());
                list[i].add(k);
                indeg[k]++;
            }
        }
    }

    static void process() {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
                result[i] = times[i];
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();

            for (Integer i : list[x]) {
                indeg[i]--;
                result[i] = Math.max(result[i], result[x] + times[i]);
                if (indeg[i] == 0) {
                    q.offer(i);
                }
            }
        }

        int max = Arrays.stream(result).max().getAsInt();
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
