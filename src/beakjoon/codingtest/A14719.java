import java.util.*;
import java.io.*;

// 빗물
@SuppressWarnings("unchecked")
class Main {

    static int w, h;
    static int[][] area;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        area = new int[h][w];
        visit = new boolean[h][w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            int x = Integer.parseInt(st.nextToken());
            for (int j = h - x; j < h; j++) {
                area[j][i] = 1;
            }
        }

    }

    static void process() {
        for (int i = 0; i < h; i++) {
            if (area[i][0] == 0) {
                for (int j = 0; j < w; j++) {
                    if (area[i][j] == 1) 
                        break;
                    area[i][j] = -1;
                }
            }

            if (area[i][w - 1] == 0) {
                for (int j = w - 1; j >= 0; j--) {
                    if (area[i][j] == 1) 
                        break;
                    area[i][j] = -1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
               if (area[i][j] == 0)
                 count++;
            }
        }

        System.out.println(count);
    }

}