package beakjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 숫자 카드 2
public class A10816 {

    static int n, m;
    static int[] a, b, count;
    static StringBuilder sb = new StringBuilder();

    static int low(int l, int r, int x) {
        int index = r + 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] >= x) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }

    static int up(int l, int r, int x) {
        int index = r + 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] > x) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return index;
    }

    static void find() {
        for (int i = 1; i <= m; i++) {
            int up = up(1, n, b[i]);
            int low = low(1, n, b[i]);

            sb.append(up - low).append(" ");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[n + 1];

        for (int ia = 1; ia <= n; ia++)
            a[ia] = Integer.parseInt(st.nextToken());
        Arrays.sort(a, 1, n + 1);
        m = Integer.parseInt(br.readLine());
        b = new int[m + 1];
        count = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int ib = 1; ib <= m; ib++)
            b[ib] = Integer.parseInt(st.nextToken());

        find();
        System.out.println(sb.toString());
    }
}
