package beakjoon.numbertheoryandcombinatorics;

import java.io.*;
import java.util.StringTokenizer;

// 최소공배수
public class A1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int big, small;

            if(n1 > n2){
                big = n1; small = n2;
            } else {
                big = n2; small = n1;
            }
            while (true) {
                int divisor = big / small;
                int rest = big % small;
                if(rest == 0) break;
                big = small;
                small = rest;
            }
            int lcm = small;
            int gcd = n1 * n2 / lcm;

            sb.append(gcd + "\n");
        }

        bw.write(sb.toString());
        bw.flush(); bw.close(); br.close();
    }
}
