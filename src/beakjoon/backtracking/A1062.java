package beakjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 가르침
// antatica
public class A1062 {

    static int n, k, count = Integer.MIN_VALUE;
    static boolean[] visit = new boolean[26];
    static String[] str;
    static HashSet<Character> hs;
    static int test = 1;

    static void setVisit() {
        visit['a' - 97] = true;
        visit['n' - 97] = true;
        visit['t' - 97] = true;
        visit['i' - 97] = true;
        visit['c' - 97] = true;
    }

    static int count() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            String s = str[i];
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                if (!visit[s.charAt(j) - 97]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;
        }
        return count;
    }

    static void dfs(int start, int depth) {
        if (depth == k) {
            int tmp = count();
            count = Math.max(tmp, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i, depth + 1);
                visit[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        str = new String[n];

        if (k < 5) {
            System.out.println(0);
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        } else {

            for (int i = 0; i < n; i++) {
                String a = br.readLine();
                str[i] = a.substring(4, a.length() - 4);
            }
            k -= 5;
            setVisit();

            dfs(0, 0);

            System.out.println(count);
        }

    }

}
