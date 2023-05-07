package beakjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M 9
public class A15663 {

    static int n, m;
    static int[] arr, result;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        result = new int[m + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr, 1, n + 1);
    }

    static void process(int k) {
        if (k == m + 1) {
            for (int i = 1; i <= m; i++)
                sb.append(result[i]).append(" ");
            sb.append("\n");
        } else {
            int used = 0;
            for (int i = 1; i <= n; i++) {
                if(arr[i] == used) continue; // 중복 제거
                if(visit[i]) continue;

                used = arr[i];
                visit[i] = true;
                result[k] = used;
                process(k + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process(1);
        System.out.println(sb);
    }
}
