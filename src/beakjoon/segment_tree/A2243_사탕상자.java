package beakjoon.segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2243_사탕상자 {

    final static int MAX = 1_000_000;
    static int n, s = 1;
    static int a, b;
    static long c;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        while (s < MAX) {
            s <<= 1;
        }
        tree = new int[2 * s];

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                b = Integer.parseInt(st.nextToken());
                int index = query(1, 1, MAX, b);
                update(1, 1, MAX, index, -1);
                sb.append(index).append('\n');
            } else if (a == 2) {
                b = Integer.parseInt(st.nextToken());
                c = Long.parseLong(st.nextToken());
                update(1, 1, MAX, b, c);
            }
        }

        System.out.println(sb);
    }

    static void update(int node, int start, int end, int targetIdx, long diff) {
        if (start > targetIdx || end < targetIdx)
            return;

        tree[node] += diff;
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update((node * 2), start, mid, targetIdx, diff);
        update((node * 2) + 1, mid + 1, end, targetIdx, diff);
    }

    static int query(int node, int start, int end, int rank) {
        if (start == end)
            return start;

        int mid = (start + end) / 2;

        if (tree[node * 2] >= rank) {
            return query(node * 2, start, mid, rank);
        } else {
            return query((node * 2) + 1, mid + 1, end, rank - tree[node * 2]);
        }
    }

}
