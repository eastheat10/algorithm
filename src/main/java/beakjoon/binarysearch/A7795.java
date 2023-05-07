package beakjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 먹을 것인가 먹힐 것인가
public class A7795 {

    static int na, nb, count;
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
        Arrays.sort(b, 1, nb + 1);

        for (int i = 1; i <= na; i++) {
            count += count(1, nb, a[i]);
        }
        sb.append(count).append("\n");
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            na = Integer.parseInt(st.nextToken());
            nb = Integer.parseInt(st.nextToken());

            a = new int[na + 1];
            b = new int[nb + 1];

            st = new StringTokenizer(br.readLine());
            for (int ia = 1; ia <= na; ia++)
                a[ia] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int ib = 1; ib <= nb; ib++)
                b[ib] = Integer.parseInt(st.nextToken());

            count = 0;
            find();
        }
        System.out.println(sb.toString());
    }
}
