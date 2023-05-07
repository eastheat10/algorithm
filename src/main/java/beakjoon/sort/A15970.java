package beakjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 화살표 그리기
public class A15970 {

    static int n;
    static int[][] arr;
    static int[] result;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int location = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            arr[i][0] = location;
            arr[i][1] = color;
        }
        result = new int[n];
    }

    static void sort() {
        Arrays.sort(arr, (i, j) -> {
            if (i[1] == j[1]) {
                return i[0] - j[0];
            } else {
                return i[1] - j[1];
            }
        });
    }

    static void print() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(i == n - 1)
                result[i] = arr[i][0] - arr[i - 1][0];
            else if (i == 0)
                result[i] = arr[i + 1][0] - arr[i][0];
            else{
                int tmp1 = Math.abs(arr[i][0] - arr[i - 1][0]);
                int tmp2 = Math.abs(arr[i + 1][0] - arr[i][0]);
                if(arr[i][1] == arr[i + 1][1] && arr[i - 1][1] == arr[i][1])
                    result[i] = tmp1 < tmp2 ? tmp1 : tmp2;
                else if(arr[i][1] == arr[i + 1][1] && arr[i - 1][1] != arr[i][1])
                    result[i] = tmp2;
                else
                    result[i] = tmp1;
            }
        }
        for (int i : result)
            sum += i;
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
        print();
    }
}
