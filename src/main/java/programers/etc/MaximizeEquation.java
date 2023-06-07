package programers.etc;

import java.util.ArrayList;
import java.util.List;

/**
 * 수식 최대화
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/67257
 */
public class MaximizeEquation {

    private static final char[] op = { '-', '*', '+' };
    private String expression;
    private long max;
    private List<Long> nums;
    private List<Character> operations;

    public long solution(String expression) {
        max = Long.MIN_VALUE;
        this.expression = expression;
        nums = new ArrayList<>();
        operations = new ArrayList<>();

        find();
        permutation(new boolean[3], new char[3], 0);

        return max;
    }

    private void find() {
        StringBuilder sb = new StringBuilder();
        int len = expression.length();

        for (int i = 0; i < len; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                nums.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operations.add(c);
            } else {
                sb.append(c);
            }
        }
        nums.add(Long.parseLong(sb.toString()));
    }

    private void permutation(boolean[] visit, char[] operation, int depth) {
        if (depth == 3) {
            calc(operation);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            operation[depth] = op[i];
            permutation(visit, operation, depth + 1);
            visit[i] = false;
        }
    }

    private void calc(char[] operation) {
        ArrayList<Long> nums = new ArrayList<>(this.nums);
        ArrayList<Character> operations = new ArrayList<>(this.operations);

        for (char o : operation) {
            for (int i = 0; i < operations.size(); i++) {
                if (o != operations.get(i)) {
                    continue;
                }

                long l1 = nums.get(i);
                long l2 = nums.get(i + 1);
                long result = operate(l1, l2, o);

                nums.remove(i + 1);
                nums.remove(i);
                nums.add(i, result);

                operations.remove(i--);
            }
        }
        max = Math.max(max, Math.abs(nums.get(0)));
    }

    private long operate(long l1, long l2, char op) {
        if (op == '+') {
            return l1 + l2;
        } else if (op == '-') {
            return l1 - l2;
        } else {
            return l1 * l2;
        }
    }

}
