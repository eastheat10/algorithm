package beakjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 누울 자리를 찾아라
public class A11652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = new String[n];

        for (int i = 0; i < n; i++)
            s[i] = br.readLine();

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (s[i].charAt(j) == '.') {
                    cnt++;
                } else {
                    if (cnt >= 2) {
                        count1++;
                    }
                    cnt = 0;
                }
                if (j == n - 1 && cnt >= 2)
                    count1++;
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (s[j].charAt(i) == '.') {
                    cnt++;
                } else {
                    if (cnt >= 2) {
                        count2++;
                    }
                    cnt = 0;
                }
                if (j == n - 1 && cnt >= 2)
                    count2++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count1).append(" ").append(count2);
        System.out.println(sb);
    }
}
