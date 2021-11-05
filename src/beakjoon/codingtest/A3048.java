import java.io.*;
import java.util.*;

// 개미
@SuppressWarnings("unchecked")
class Main {

    static class Ant {
        char c;
        char group;
        Ant(char c, char group) {
            this.c = c;
            this.group = group;
        }
    }
    static int N1, N2;
    static Ant[] order;
    static int time;

    public static void main(String[] args) throws IOException {
        input();
        jump();
        print();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N1 = Integer.parseInt(st.nextToken());
        N2 = Integer.parseInt(st.nextToken());
        order = new Ant[N1 + N2];
        
        String s1 = br.readLine();
        for (int i = N1 - 1; i >= 0; i--) {
            char c = s1.charAt((N1 - 1) - i);
            order[i] = new Ant(c, 'A');
        }

        String s2 = br.readLine();
        for (int i = 0; i < N2; i++) {
            char c = s2.charAt(i);
            order[i + N1] = new Ant(c, 'B');
        }

        time = Integer.parseInt(br.readLine());

    }

    static void jump() {
        while (time-- > 0) {
            for (int i = 0; i < order.length - 1; i++) {
                Ant cur = order[i];
                Ant next = order[i + 1];
                if (cur.group == 'A' && cur.group != next.group) {
                    swap(i);
                    i++;
                }
            }
        }
    }

    static void swap(int i) {
        Ant tmp = order[i];
        order[i] = order[i + 1];
        order[i + 1] = tmp;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (Ant ant : order) {
            sb.append(ant.c);
        }
        System.out.println(sb);
    }

}