package algo.stage15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 동전0
public class A11047 {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];

        for (int i = 0; i < n; i++)
            coin[i] = Integer.parseInt(br.readLine());

        while (true) {
            int tmp = 1;
            int cnt = 0;

            for (int i = n - 1; i >= 0; i--) {
                if (coin[i] <= price) {
                    tmp = coin[i];
                    break;
                }
            }
            cnt = price / tmp;
            count += cnt;
            price -= cnt * tmp;
            if(price == 0) break;
        }

        System.out.println(count);

    }
}
