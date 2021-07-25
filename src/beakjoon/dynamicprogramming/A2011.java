package beakjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 암호 코드
public class A2011 {

    static String code;
    static int len;
    static int[] dp;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        code = br.readLine();
        len = code.length();
        dp = new int[code.length()];
    }

    static void decode() {
        if (len == 0 || code.charAt(0) == '0') {
            System.out.println(0);
            return;
        }
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            if (code.charAt(i) == '0') {    // 현재 위치의 글자가 0
                if (code.charAt(i - 1) == '1' || code.charAt(i - 1) == '2') {
                    dp[i] = dp[i - 1] % 1000000;
                } else {
                    System.out.println(0);
                    return;
                }
            } else {    // 현재 위치의 글자가 0이 아닐 때
                if (code.charAt(i - 1) == '0') {    // 앞이 0
                    dp[i] = dp[i - 1];
                } else if (i + 1 < len && code.charAt(i + 1) == '0') { // 뒤가 0
                    int k = Integer.parseInt(code.substring(i, i + 2));
                    if (k <= 26) {
                        dp[i] = dp[i - 1] % 1000000;
                    } else {
                        System.out.println(0);
                        return;
                    }
                } else {    // 앞, 뒤가 모두 0이 아닐 때
                    int k = Integer.parseInt(code.substring(i - 1, i + 1));
                    if (k <= 26) {
                        if (i - 2 >= 0)
                            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                        else
                            dp[i] = (dp[i - 1] + 1) % 1000000;
                    } else {
                        dp[i] = dp[i - 1] % 1000000;
                    }
                }
            }

        }

        System.out.println(dp[len - 1]);

    }

    public static void main(String[] args) throws IOException {
        input();
        decode();
    }
}
