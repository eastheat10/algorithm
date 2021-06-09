package beakjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 암호 만들기
public class A1759 {

    static int l, c;
    static char[] arr;
    static char[] result;
    static char used = 'A';
    static boolean[] visit;
    static boolean check = false;   // 모음이 사용되었는지 체크
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c + 1];
        result = new char[l + 1];
        visit = new boolean[c + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= c; i++)
            arr[i] = st.nextToken().charAt(0);
        Arrays.sort(arr, 1, c + 1);
    }

    static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    static void process(int k) {
        if (k == l + 1) {
            if (check) {
                StringBuilder sb1 = new StringBuilder();
                int consonant = 0;
                int vowel = 0;
                for (int i = 1 ; i <= l; i++) {
                    if(isVowel(result[i]))
                        vowel++;
                    else
                        consonant++;
                    sb1.append(result[i]);
                }
                if(consonant >= 2 && vowel >= 1)
                    sb.append(sb1).append('\n');

            }
        } else {
            for (int i = 1; i <= c; i++) {
                char ch = arr[i];
                if(visit[i]) continue;
                if(ch < used) continue;
                if (!check)
                    check = true;
                result[k] = ch;
                visit[i] = true;
                used = ch;
                process(k + 1);
                check = false;
                visit[i] = false;
                used = 'A';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process(1);
        System.out.println(sb);
    }
}
