package beakjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 알파벳 개수
public class A10808 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int[] a = new int[26];

        for (int i = 0; i < s.length(); i++)
            a[s.charAt(i) - 97]++;

        for (int i : a)
            sb.append(i).append(" ");

        System.out.println(sb);
    }
}
