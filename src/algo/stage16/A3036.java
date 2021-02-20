package algo.stage16;

import java.io.*;
import java.util.StringTokenizer;

// 링
public class A3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] ring = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            ring[i] = Integer.parseInt(st.nextToken());

        int lcm = 0;
        int big, small;
        for (int i = 1; i < n; i++) {
            if(ring[0] > ring[i]){
                big = ring[0];
                small = ring[i];
            } else{
                big = ring[i];
                small = ring[0];
            }
            while (true) {
                int divisor = big / small;
                int rest = big % small;
                if (rest == 0)
                    break;
                big = small;
                small = rest;
            }
            lcm = small;
            sb.append(String.format("%d/%d\n", ring[0] / lcm, ring[i] / lcm));
        }

        bw.write(sb.toString());
        bw.flush(); bw.close(); br.close();
    }
}
