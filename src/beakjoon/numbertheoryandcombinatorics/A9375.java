package beakjoon.numbertheoryandcombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 패션왕 신혜빈
public class A9375 {

    static int find(HashMap<String, Integer> hm) {
        int result = 1;

        for (String s : hm.keySet())
            result *= (hm.get(s) + 1);

        return (result - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hm = new HashMap<>();

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();
                hm.put(s2, hm.getOrDefault(s2, 0) + 1);
            }

            sb.append(find(hm)).append('\n');
        }

        System.out.println(sb);
    }

}
