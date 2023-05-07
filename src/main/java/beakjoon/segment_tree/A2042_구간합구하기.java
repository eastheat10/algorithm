package beakjoon.segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2042_구간합구하기 {

    static int n, m, k, s = 1;
    static long[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        while (s < n) {
            s <<= 1;
        }

        tree = new long[s * 2];

        init(1, 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                update(1, 1, n, b, diff);
            } else if (a == 2) {
                sb.append(query(1, 1, n, b, (int) c)).append('\n');
            }
        }

        System.out.println(sb);
    }

    static long init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = init((node * 2), start, mid) +
                init((node * 2) + 1, mid + 1, end);
    }

    static void update(int node, int start, int end, int targetIdx, long diff) {
        if (targetIdx < start || end < targetIdx){
            return;
        }

        tree[node] += diff;
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update((node * 2), start, mid, targetIdx, diff);
        update((node * 2) + 1, mid + 1, end, targetIdx, diff);
    }

    static long query(int node, int start, int end, int targetLeft, int targetRight) {
        if (targetRight < start || end < targetLeft) {
            return 0;
        }

        if (targetLeft <= start && end <= targetRight) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return query((node * 2), start, mid, targetLeft, targetRight) +
                query((node * 2) + 1, mid + 1, end, targetLeft, targetRight);
    }
}
