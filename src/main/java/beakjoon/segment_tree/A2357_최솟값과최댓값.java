package beakjoon.segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A2357_최솟값과최댓값 {

    static int n, m, s = 1;
    static int[] arr, maxTree, minTree;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        while (s < n) {
            s <<= 1;
        }
        arr = new int[n + 1];
        maxTree = new int[s * 2];
        minTree = new int[s * 2];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init_min(1, n, 1);
        init_max(1, n, 1);

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(String.format("%d %d\n", query_min(1, n, 1, a, b), query_max(1, n, 1, a, b)));
        }

        System.out.println(sb);

    }

    static int init_min(int start, int end, int node) {
        if (start == end) {
            return minTree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return minTree[node] = Math.min(
                init_min(start, mid, (node * 2)),
                init_min(mid + 1, end, (node * 2) + 1)
        );
    }

    static int init_max(int start, int end, int node) {
        if (start == end) {
            return maxTree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return maxTree[node] = Math.max(
                init_max(start, mid, (node * 2)),
                init_max(mid + 1, end, (node * 2) + 1)
        );
    }

    static int query_min(int start, int end, int node, int tLeft, int tRight) {
        if (tRight < start || end < tLeft) {
            return Integer.MAX_VALUE;
        }

        if (tLeft <= start && end <= tRight) {
            return minTree[node];
        }

        int mid = (start + end) / 2;
        return Math.min(
                query_min(start, mid, (node * 2), tLeft, tRight),
                query_min(mid + 1, end, (node * 2) + 1, tLeft, tRight)
        );
    }

    static int query_max(int start, int end, int node, int tLeft, int tRight) {
        if (tRight < start || end < tLeft) {
            return 0;
        }

        if (tLeft <= start && end <= tRight) {
            return maxTree[node];
        }

        int mid = (start + end) / 2;
        return Math.max(
                query_max(start, mid, (node * 2), tLeft, tRight),
                query_max(mid + 1, end, (node * 2) + 1, tLeft, tRight)
        );
    }
}
