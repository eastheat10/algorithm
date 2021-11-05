import java.io.*;
import java.util.*;

// 도로와 신호등
@SuppressWarnings("unchecked")
class Main {

    static class Traffic {
        int d;
        int r;
        int g;
        Traffic (int d, int r, int g) {
            this.d = d;
            this.r = r;
            this.g = g;
        }
    }
    static int n, l;
    static Queue<Traffic> light = new LinkedList<>();
    static int position = 0;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        input();
        process();
        System.out.println(time);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            light.offer(new Traffic(d, r, g));
        }


    }

    static void process() {
        while (true) {
            if (position == l)
                break;
            
            if (!light.isEmpty() && light.peek().d == position) {
                Traffic traffic = light.poll();
                int t = time % (traffic.r + traffic.g);
                if (0 <= t && t <= traffic.r) {
                    time += (traffic.r - t);
                }
            }
            time++;
            position++;
        }
    }

}