package beakjoon.stage20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A1764 {

    static int n, m, count = 0;
    static String[] hear, see;
    static StringBuilder sb = new StringBuilder();

    public static boolean check(int l, int r, String x) {
        boolean result = false;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (hear[mid].compareTo(x) >= 0) {
                if (hear[mid].equals(x)) {
                    result = true;
                    break;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    public static void find() {
        Arrays.sort(hear, 1, n + 1);
        Arrays.sort(see, 1, m + 1);
        for (int i = 1; i <= m; i++) {
            if (check(1, n, see[i])) {
                count++;
                sb.append(see[i]).append("\n");
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        hear = new String[n + 1];
        see = new String[m + 1];

        for (int i = 1; i <= n; i++)
            hear[i] = br.readLine();

        for (int i = 1; i <= m; i++)
            see[i] = br.readLine();

        find();
        System.out.println(count);
        System.out.println(sb.toString());
    }

}
