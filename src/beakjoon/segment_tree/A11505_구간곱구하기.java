package beakjoon.segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A11505_구간곱구하기 {

    final static int CONST = 1_000_000_007;
    static int n, m, k, s = 1;
    static long[] arr, tree;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        while (s < n) {
            s <<= 1;
        }
        arr = new long[n + 1];
        tree = new long[s * 2];

        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, n, 1);

        int a, b;
        long c;
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());

            if (a == 1) {   // update
                arr[b] = c;
                update(1, n, 1, b, c);
            } else if (a == 2) {    // get value
                sb.append(query(1, n, 1, b, (int) c)).append('\n');
            }
        }

        System.out.println(sb);
    }

    static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = (init(start, mid, (node * 2)) *
                init(mid + 1, end, (node * 2) + 1)) % CONST;
    }

    static long update(int start, int end, int node, int targetIdx, long value) {
        if (targetIdx < start || end < targetIdx)
            return tree[node];

        if (start == end)
            return tree[node] = value;

        int mid = (start + end) / 2;
        return tree[node] = (update(start, mid, (node * 2), targetIdx, value) *
                update(mid + 1, end, (node * 2) + 1, targetIdx, value)) % CONST;
    }

    static long query(int start, int end, int node, int tLeft, int tRight) {
        if (tRight < start || end < tLeft)
            return 1;

        if (tLeft <= start && end <= tRight)
            return tree[node];

        int mid = (start + end) / 2;
        return (query(start, mid, (node * 2), tLeft, tRight) *
                query(mid + 1, end, (node * 2) + 1, tLeft, tRight)) % CONST;
    }
}
