import java.io.*;
import java.util.*;

// 수들의 합
@SuppressWarnings("unchecked")
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long sum = 0;
        int cnt = 0;

        while (sum < n) {
            sum += ++cnt;
        }

        int result = sum == n ? cnt : cnt - 1;

        System.out.println(result);
    }
}