package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 연결 요소의 개수
public class A11724 {

    static int n, m;
    static ArrayList<Integer>[] arr;
    static boolean[] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = new ArrayList<>();

        visit = new boolean[n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
    }

    static void dfs(int idx) {
        visit[idx] = true;
        for (int i = 0; i < arr[idx].size(); i++) {
            int linkedIdx = arr[idx].get(i);
            if (!visit[linkedIdx] && arr[linkedIdx].size() > 0) {
                dfs(linkedIdx);
            }
        }
    }

    static void process() {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
