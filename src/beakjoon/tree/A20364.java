package beakjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부동산 다툼
public class A20364 {

    static int n, q;
    static int[] num;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        num = new int[q + 1];
        for (int i = 1; i <= q; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        visit = new boolean[n + 1];
    }

    static void process() {
        for (int i = 1; i <= q; i++) {
            int x = num[i];
            int result = 0;
            while (x > 1) {
                if (visit[x]) {
                    result = x;
                }
                x /= 2;
            }
            visit[num[i]] = true;
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
