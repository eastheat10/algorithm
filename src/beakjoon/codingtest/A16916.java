import java.util.*;
import java.io.*;

// 부분 문자열
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        String p = br.readLine();
        
        System.out.println(kmp(s, p));
    }

    static int kmp(String s, String p) {
        int[] table = makeTable(p);
        int n1 = s.length();
        int n2 = p.length();
        int idx = 0;

        for (int i = 0; i < n1; i++) {
            while (idx > 0 && (s.charAt(i) != p.charAt(idx))) {
                idx = table[idx - 1];
            } 

            if (s.charAt(i) == p.charAt(idx)) {
                if (idx == n2 - 1) {
                    idx = table[idx];
                    return 1;
                } else {
                    idx++;
                }
            }
        }

        return 0;
    }

    static int[] makeTable(String p) {
        int n = p.length();
        int idx = 0;
        int[] table = new int[n];

        for (int i = 1; i < n; i++) {
            while (idx > 0 && (p.charAt(i) != p.charAt(idx))) {
                idx = table[idx - 1];
            }

            if (p.charAt(i) == p.charAt(idx)) {
                table[i] = ++idx;
            }
        }

        return table;
    }

}

