package beakjoon.numbertheoryandcombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count1 = 0, count2 = 0;

        while (n >= 5) {
            count1 += n / 5;
            n /= 5;
        }

        while (m >= 5) {
            count2 += m / 5;
            m /= 5;
        }

        System.out.println(count1 - count2);

    }
}
