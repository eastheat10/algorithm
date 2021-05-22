package beakjoon.stage14;

import java.io.*;
import java.util.Arrays;

// 01타일
public class A1904 {

    static int[] arr = new int[1000001];

    public static int tile(int n) {
        if(arr[n] == -1){
            arr[n] = (tile(n - 1) + tile(n - 2)) % 15746;
        }
        return arr[n];
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        Arrays.fill(arr, -1);
        int result = tile(n);


        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
