package beakjoon.numbertheoryandcombinatorics;

import java.io.*;
import java.util.StringTokenizer;

// 이항계수2
public class A11051 {

    static int n, k;
    static int[][] com;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        com = new int[n + 1][k + 1];
    }

    static int combination(int n, int r) {
        if(com[n][r] > 0)
            return com[n][r];
        if (n == r || r == 0)
            return com[n][r] = 1;
        return com[n][r] = combination(n - 1, r - 1) + combination(n - 1, r) % 10007;
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(combination(n, k));
    }

}
