package beakjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 고냥이
public class A16472 {

    static int n;
    static String s;
    static int[] alphabet = new int[26];
    static int alphaCount = 0;
    // A: 65, a: 97

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();
    }

    static void add(char x) {
        alphabet[x - 'a']++;
        if (alphabet[x - 'a'] == 1)
            alphaCount++;
    }

    static void erase(char x) {
        alphabet[x - 'a']--;
        if (alphabet[x - 'a'] == 0)
            alphaCount--;
    }

    public static void find() {
        int result = 0;
        int l = 0;
        int len = s.length();
        for (int r = 0; r < len; r++) {

            // r번째 문자를 오른쪽에 추가
            add(s.charAt(r));

            // 불가능하다면 가능할 때 까지 l 이동
            while (alphaCount > n) {
                erase(s.charAt(l++));
            }

            result = Math.max(result, r - l + 1);
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        find();
    }
    /**
     * 2
     * abbcaccba
     * -----
     * 4
     */
}
