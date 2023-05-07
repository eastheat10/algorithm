package beakjoon.hash;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

// 비밀번호 찾기
public class A17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> hm = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pw = st.nextToken();
            hm.put(site, pw);
        }

        for (int i = 0; i < m; i++) {
            String site = br.readLine();
            String pw = hm.get(site);
            sb.append(pw).append('\n');
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
