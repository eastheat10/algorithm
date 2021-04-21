package beakjoon.stage16;

import java.io.*;
import java.util.StringTokenizer;

// 이항계수1
public class A11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int multiple = 1;
        int tmp = n;
        for(int i = k; i > 0; i--)
            multiple *= tmp--;
        for (int j = k; j > 0; j--)
            multiple /= j;

        bw.write(Integer.toString(multiple));
        bw.flush(); bw.close(); br.close();
    }
}
