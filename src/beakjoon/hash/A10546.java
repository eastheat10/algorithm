package beakjoon.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 배부른 마라토너
public class A10546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            hm.put(name, hm.getOrDefault(name, 0) + 1);
        }

        for (int i = 0; i < n - 1; i++) {
            String finish = br.readLine();
            hm.put(finish, hm.get(finish) - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String s : hm.keySet()) {
            if (hm.get(s) == 1)
                sb.append(s);
        }
        System.out.println(sb);
    }
}
