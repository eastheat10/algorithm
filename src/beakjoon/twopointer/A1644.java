package beakjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 소수의 연속 합
public class A1644 {

    static int n, len;
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean[] prime;

    static void prime() {
        prime = new boolean[n + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i])
                continue;
            for (int j = i * i; j <= n; j += i)
                prime[j] = true;
        }

        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                list.add(i);
            }
        }
        len = list.size();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

    static void process() {
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;

        while (true) {
            if (sum >= n)
                sum -= list.get(l++);
            else if(r == list.size())
                break;
            else
                sum += list.get(r++);

            if (sum == n)
                count++;
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        input();
        prime();
        process();
    }

}
