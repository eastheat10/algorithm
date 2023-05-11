package beakjoon.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1976번 여행가자
 * https://www.acmicpc.net/problem/1976
 */
public class A1976 {

    private static int n, m;
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        tree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        String result = "YES";

        for (int i = 1; i < m; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (start != find(now)) {
                result = "NO";
                break;
            }
        }

        System.out.println(result);
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x == y) {
            return;
        }

        if (x > y) {
            tree[x] = y;
        } else {
            tree[y] = x;
        }

    }

    private static int find(int x) {
        if (x == tree[x]) {
            return x;
        }

        tree[x] = find(tree[x]);

        return tree[x];
    }


}
