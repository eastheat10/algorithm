package beakjoon.stage20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수 찾기
public class A1920 {

    static int n, m;
    static int[] a, b;
    static StringBuilder sb = new StringBuilder();

    static boolean check(int l, int r, int x) {
        boolean contain = false;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] <= x) {
                l = mid + 1;
                if (a[mid] == x) {
                    contain = true;
                    break;
                }
            } else {
                r = mid - 1;
            }
        }

        return contain;
    }

    public static void find() {
        for (int i = 1; i <= m; i++)
            if(check(1, n, b[i]))
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(a, 1, n + 1);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        b = new int[m + 1];
        for (int i = 1; i <= m; i++)
            b[i]=Integer.parseInt(st.nextToken());

        find();
        System.out.println(sb.toString());
    }
}
