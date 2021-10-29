import java.util.*;
import java.io.*;

// 첼시를 도와줘!
@SuppressWarnings("unchecked")
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        while (n-- > 0) {
            HashMap<Integer, String> priceName = new HashMap<>();
            int p = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < p; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int price = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                priceName.put(price, name);
            }

            List<Integer> list = new ArrayList<>(priceName.keySet());
            list.sort((i, j) -> j - i);
            sb.append(priceName.get(list.get(0))).append('\n');
        }

        System.out.println(sb);
    }

}
