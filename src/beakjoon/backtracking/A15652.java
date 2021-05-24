package beakjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (4)
public class A15652 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr;

    public static void dfs(int depth) {
        if (depth == m) {
            for (int num : arr) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (depth > 0) {
                if (arr[depth - 1] > (i + 1)) {
                    continue;
                }
            }
            arr[depth] = i + 1;
            dfs(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(0);

        System.out.println(sb);
        br.close();
    }
}
