import java.io.*;
import java.util.*;

// 감소하는 수
@SuppressWarnings("unchecked")
class Main {

    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n <= 10){
            System.out.println(n);
        } else if (n > 1022) {  // 0 ~ 9 의 부분집합의 개수 = 2 ^ 10 - 1 (공집합) (9876543210 <- 1022번째 수)
            System.out.println(-1);
        } else {
            for (int i = 0; i < 10; i++)
                find(i, 1);

            Collections.sort(list);
            System.out.println(list.get(n));
        }
        
        
    }

    static void find(long num, int depth) {
        if (depth > 10)
            return;
        
        list.add(num);

        for(int i = 0; i < 10; i++) {
            if (num % 10 > i) {
                find((num * 10) + i, depth + 1);
            }
        }

    }
}