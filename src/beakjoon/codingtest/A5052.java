import java.util.*;
import java.io.*;

// 전화번호 목록
@SuppressWarnings("unchecked")
class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while(t-- > 0) {
            HashSet<String> numberList = new HashSet<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String number = br.readLine();
                numberList.add(number);
            }
            process(n, numberList);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void process(int n, HashSet<String> numberList) {
        for (String s : numberList) {
            for (int i = 1; i < s.length(); i++) {
                String sub = s.substring(0, i);
                if (numberList.contains(sub)) {
                    sb.append("NO");
                    return;
                }
            }
        }

        sb.append("YES");
    }
}
