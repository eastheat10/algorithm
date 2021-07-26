package beakjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리 순회
public class A1991_2 {

    static int n;
    static int[][] tree = new int[26][2];
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int ch = c - 'A';
            for (int j = 0; j < 2; j++) {
                char value = st.nextToken().charAt(0);
                if (value == '.')
                    tree[ch][j] = -1;
                else
                    tree[ch][j] = value - 'A';
            }

        }
    }

    static void preOrder(int x) {
        if (x == -1) return;
        sb.append((char) (x + 'A'));
        preOrder(tree[x][0]);
        preOrder(tree[x][1]);
    }

    static void inOrder(int x) {
        if (x == -1) return;
        inOrder(tree[x][0]);
        sb.append((char) (x + 'A'));
        inOrder(tree[x][1]);
    }

    static void postOrder(int x) {
        if (x == -1) return;
        postOrder(tree[x][0]);
        postOrder(tree[x][1]);
        sb.append((char) (x + 'A'));
    }

    static void search() {
        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        search();
    }

}
