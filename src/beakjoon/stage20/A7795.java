package beakjoon.stage20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 먹을 것인가 먹힐 것인가
public class A7795 {

    static int n, na, nb, count;
    static int[] a, b;
    static StringBuilder sb = new StringBuilder();

    public static int count(int l, int r, int x) {
        int result = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (b[mid] < x) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    public static void find() {
        Arrays.sort(b);

        for (int i = 0; i < na; i++) {
            count += count(0, b.length - 1, a[i]);
        }
        sb.append(count).append("\n");
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            na = Integer.parseInt(st.nextToken());
            nb = Integer.parseInt(st.nextToken());

            a = new int[na];
            b = new int[nb];

            st = new StringTokenizer(br.readLine());
            for (int ia = 0; ia < na; ia++)
                a[ia] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int ib = 0; ib < nb; ib++)
                b[ib] = Integer.parseInt(st.nextToken());

            count = 0;
            find();
        }

        System.out.println(sb.toString());

    }
}
