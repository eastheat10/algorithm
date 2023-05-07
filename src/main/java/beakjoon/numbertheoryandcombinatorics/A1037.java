package beakjoon.numbertheoryandcombinatorics;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

// 약수
public class A1037 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] divisor = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            divisor[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(divisor);

        int N = divisor[0] * divisor[n - 1];

        bw.write(Integer.toString(N));
        bw. flush(); bw.close(); br.close();
    }

}