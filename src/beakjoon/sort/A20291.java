package beakjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// 파일 정리
public class A20291 {

    static int n;

    static HashMap<String, Integer> hm = new HashMap<>();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            String name = st.nextToken();
            String extension = st.nextToken();
            hm.put(extension, hm.getOrDefault(extension, 0) + 1);
        }
    }

    static void sort() {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>(hm.keySet());
        list.sort((i, j) -> i.compareTo(j));
        for (String s1 : list)
            sb.append(s1).append(" ").append(hm.get(s1)).append("\n");

        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
    }

}
