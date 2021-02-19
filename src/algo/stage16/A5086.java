package algo.stage16;

import java.io.*;
import java.util.StringTokenizer;

// 배수와 약수
public class A5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if (n1 == 0 && n2 == 0)
                break;

            if(n2 % n1 == 0)
                sb.append("factor\n");
            else if (n1 % n2 == 0)
                sb.append("multiple\n");
            else
                sb.append("neither\n");

        }
        bw.write(sb.toString());
        bw. flush(); bw.close(); br.close();
    }
}
