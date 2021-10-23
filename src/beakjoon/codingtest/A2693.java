import java.util.*;
import java.io.*;

// N번째 큰 수
@SuppressWarnings("unchecked")
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            list.sort((i, j) -> i - j);
            sb.append(list.get(7)).append('\n');
        }

        System.out.println(sb);
    }
}