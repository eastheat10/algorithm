import java.util.*;
import java.io.*;

// 쉽게 푸는 문제
@SuppressWarnings("unchecked")
class Main {

    static int a, b;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

    }

    static void process() {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int cnt = 1;

        while (true) {
            for (int i = 0; i < cnt; i++) {
                list.add(cnt);
            }
            if (list.size() >= b) break;
            cnt++;
        }
        
        int sum = 0;
        for (int i = (a - 1); i < b; i++) {
            sum += list.get(i);
        }

        System.out.println(sum);
    }
}