package beakjoon.segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class A7578_공장 {

    static int n, s = 1, offset = 0;
    static long answer = 0;
    static int[] a;
    static long[] tree;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();
        process();
        System.out.println(answer);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new int[n + 1];

        while (s < n) {
            s <<= 1;
        }
        tree = new long[s * 2];
        offset = s - 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            map.put(Integer.parseInt(st.nextToken()), i);
        }
    }

    static void process() {
        int index;
        for (int i = 1; i <= n; i++) {
            index = map.get(a[i]);
            answer += getSum(index + 1, n);
            update(index, 1);
        }
    }

    static long getSum(int left, int right) {
        long sum = 0;
        left += offset;
        right += offset;

        while (left <= right) {
            if (left % 2 == 1) {
                sum += tree[left];
                left++;
            }

            if (right % 2 == 0) {
                sum += tree[right];
                right--;
            }

            left >>= 1;
            right >>= 1;
        }

        return sum;
    }

    static void update(int index, int value) {
        index += offset;
        tree[index] += value;

        for (index /= 2; index > 0; index /= 2) {
            tree[index] = tree[index * 2] + tree[index * 2 + 1];
        }
    }

    static void update2(int left, int right, int index, int value) {
        if (left > index && right < index) {
            return;
        }

        tree[index] += value;
        if (left == right) return;

        int mid = (left + right) / 2;
        update2(left, mid, (index * 2), value);
        update2(mid + 1, right, (index * 2) + 1, value);
    }
}