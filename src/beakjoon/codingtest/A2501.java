import java.util.*;
import java.io.*;

// 약수 구하기
@SuppressWarnings("unchecked")
class Main {

    static int n, k;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

    }

    static void process() {
        HashSet set = new HashSet();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        list.sort((i, j) -> i - j);
        int result = 0;
        if (list.size() > (k - 1))
            result = list.get(k - 1);
        System.out.println(result);
    }
}