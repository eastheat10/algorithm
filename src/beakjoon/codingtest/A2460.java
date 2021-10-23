import java.util.*;
import java.io.*;

// 지능형 기차2
@SuppressWarnings("unchecked")
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            sum -= out;
            sum += in;

            result = Math.max(sum, result);
            
        }

        System.out.println(result);
    }
}