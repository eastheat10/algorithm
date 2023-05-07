package beakjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 잃어버린 괄호
public class A1541 {

    static String s;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
    }

    static void greedy() {
        StringTokenizer sub = new StringTokenizer(s, "-");

        int sum = Integer.MAX_VALUE;

        while (sub.hasMoreTokens()) {
            int tmp = 0;
            StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");

            while (add.hasMoreTokens())
                tmp += Integer.parseInt(add.nextToken());

            if (sum == Integer.MAX_VALUE) {
                sum = tmp;
            } else {
                sum -= tmp;
            }
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        input();
        greedy();
    }
}
