package algo.stage14;

import java.io.*;

// 파도반 수열
public class A9461 {
    public static long[] arr = new long[101];

    public static long padovan(int n) {
        if (n <= 10) 
            return arr[n];

        if (arr[n] == 0)
            arr[n] = padovan(n - 1) + padovan(n - 5);
        return arr[n];
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        arr[6] = 3;
        arr[7] = 4;
        arr[8] = 5;
        arr[9] = 7;
        arr[10] = 9;
        for(int i = 0; i < n; i++)
            sb.append(padovan(Integer.parseInt(br.readLine())) + "\n");

        bw.write(sb.toString());
        bw.flush(); bw.close(); br.close();
    }
}
