import java.util.*;
import java.io.*;

// 이진수
@SuppressWarnings("unchecked")
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(process(n)).append('\n');
        }
        System.out.println(sb);
    }

    static StringBuilder process(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int t = n % 2;
            sb.append(t);
            n /= 2;
        }

        String s = sb.toString();
        sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sb.append(i).append(" ");
            }
        }

        return sb;
    }
}