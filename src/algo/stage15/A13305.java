package algo.stage15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주유소
public class A13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cities = Integer.parseInt(br.readLine());
        long price = 0;  // 총 가격

        // 거리 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] distance = new long[cities - 1];
        for (int i = 0; i < cities - 1; i++)
            distance[i] = Long.parseLong(st.nextToken());

        // 기름값 입력
        st = new StringTokenizer(br.readLine());
        long[] oilPrice = new long[cities];
        for (int i = 0; i < cities; i++)
            oilPrice[i] = Long.parseLong(st.nextToken());

        // 최저 기름값
        long minPrice = oilPrice[0];
        for (int i = 0; i < cities - 1; i++) {

            // 주유소를 지날 때 마다 가격을 확인
            // 현재 가격보다 싸면 가격 업데이트
            if (minPrice > oilPrice[i])
                minPrice = oilPrice[i];

            price += minPrice * distance[i];

        }

        System.out.println(price);

    }
}
