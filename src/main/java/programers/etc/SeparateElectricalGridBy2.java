package programers.etc;

/**
 * 전력망 둘로 나누기
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */
public class SeparateElectricalGridBy2 {

    private int n;
    private int[] tree;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        this.n = n;

        for (int i = 0; i < wires.length; i++) {
            initTree();

            for (int j = 0; j < wires.length; j++) {
                if (i == j) {
                    continue;
                }

                int v1 = wires[j][0];
                int v2 = wires[j][1];

                union(v1, v2);
            }

            answer = Math.min(answer, checkTree());
        }

        return answer;
    }

    private void initTree() {
        tree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = i;
        }
    }

    private void union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);

        if (v1 == v2) {
            return;
        }

        if (v1 > v2) {
            tree[v1] = v2;
        } else {
            tree[v2] = v1;
        }
    }

    private int find(int v) {
        if (tree[v] == v) {
            return v;
        }

        tree[v] = find(tree[v]);
        return tree[v];
    }

    private int checkTree() {
        int a = 0;

        for (int i = 1; i <= n; i++) {
            if (find(tree[i]) == 1) {
                a++;
            }
        }

        int b = n - a;

        return Math.abs(b - a);
    }

}
