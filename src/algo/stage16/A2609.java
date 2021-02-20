package algo.stage16;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최대공약수와 최소공배수
public class A2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int n1 = Integer.parseInt(st.nextToken()),
            n2 = Integer.parseInt(st.nextToken());
        int big, small;
        int portion , rest; // 몫, 나머지
        int gcd = 0; // 최대공약수
        int lcm = 0; // 최소공배수

        if(n1 > n2){
            big = n1;
            small = n2;
        } else{
            big = n2;
            small =n1;
        }

        while (true) {
            portion = big / small;
            rest = big % small;

            if(rest == 0)
                break;

            big = small;
            small = rest;
        }

        gcd = small;
        lcm = n1 * n2 / gcd;

        sb.append(gcd + "\n" + lcm);
        bw.write(sb.toString());
        bw.flush();bw.close();br.close();

    }
}
