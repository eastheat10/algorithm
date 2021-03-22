package algo.stage15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 캠핑
public class A4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());   // L일 동안 사용가능
            int p = Integer.parseInt(st.nextToken());   // 연속하는 P일 중
            int v = Integer.parseInt(st.nextToken());   // 휴가 일수

            int totalUse = 0;   // 캠핑장 사용 일 수

            if(l == 0)
                break;
            count++;

            int tmp = v / p;
            totalUse = tmp * l;
            v -= tmp * p;
            if (l > v) {
                totalUse += v;
            } else {
                totalUse += l;
            }

            sb.append(String.format("Case %d: %d\n", count, totalUse));
        }
        System.out.println(sb);
        br.close();

    }
}
