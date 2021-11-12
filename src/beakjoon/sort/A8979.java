import java.io.*;
import java.util.*;

// 올림픽
class Main {
    static class Medal {
        int num;
        int g, s, b;

        Medal (int num, int g, int s, int b) {
            this.num = num;
            this.g = g;
            this.s = s;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Medal> list = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Medal(num, g, s, b));
        }

        list.sort((m1, m2) -> {
            if (m2.g == m1.g && m2.s == m1.s) {
                return m2.b - m1.b;
            } else if (m2.g == m1.g) {
                return m2.s - m1.s;
            } else {
                return m2.g - m1.g;
            }
        });

        Map<Integer, Integer> nationRank = new HashMap<>();
        nationRank.put(list.get(0).num, 1);
        for (int i = 1; i < list.size(); i++) {
            Medal m1 = list.get(i - 1);
            Medal m2 = list.get(i);

            if (m1.g == m2.g && m1.s == m2.s && m1.b == m2.b) {
                nationRank.put(m2.num, nationRank.get(m1.num));
            } else {
                nationRank.put(m2.num, i + 1);
            }
        }

        System.out.println(nationRank.get(k));
        
    }
}