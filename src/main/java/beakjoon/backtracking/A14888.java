package beakjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연산자 끼워넣기
public class A14888 {

    static int n;
    static int max, min;
    static int[] operator = new int[5]; // + - * /
    static int[] num, order;
    static StringBuilder sb = new StringBuilder();

//    static int calculator() {
//        int value = num[1];
//        for (int i = 1; i <= n; i++) {
//            switch (order[i]) {
//                case 1:
//                    value += num[i + 1];
//                    break;
//                case 2:
//                    value -= num[i + 1];
//                    break;
//                case 3:
//                    value *= num[i + 1];
//                    break;
//                case 4:
//                    value /= num[i + 1];
//                    break;
//            }
//        }
//        return value;
//    }
//
//    static void func(int depth) {
//        if (depth == n) {
//            // 연산자는 수의 개수보다 하나 덜 필요함.
//            int value = calculator();
//            max = Math.max(max, value);
//            min = Math.min(min, value);
//        } else {
//            for (int i = 1; i <= 4; i++) {
//                if (operator[i] > 0) {
//                    operator[i]--;
//                    order[depth] = i;
//                    func(depth + 1);
//                    operator[i]++;
//                    order[depth] = 0;
//                }
//            }
//        }
//    }

    static int calculate(int operator, int operand1, int operand2) {
        int result = 0;
        switch (operator) {
            case 1:
                result = operand1 + operand2;
                break;
            case 2:
                result = operand1 - operand2;
                break;
            case 3:
                result = operand1 * operand2;
                break;
            case 4:
                result = operand1 / operand2;
                break;
        }
        return result;
    }

    static void func(int depth, int value) {
        if (depth == n) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int i = 1; i <= 4; i++) {
                if (operator[i] > 0) {
                    operator[i]--;
                    func(depth + 1, calculate(i, value, num[depth + 1]));
                    operator[i]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n + 1];
        order = new int[n + 1];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            num[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < 5; i++)
            operator[i] = Integer.parseInt(st.nextToken());

        func(1, num[1]);

        sb.append(max).append("\n").append(min);
        System.out.println(sb.toString());
    }

}
