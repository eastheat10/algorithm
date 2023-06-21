package programers.etc;

/**
 * 멀쩡한 사각형
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/62048
 */
public class NormalSquare {

    public long solution(int w, int h) {

        long W = w;
        long H = h;

        // (w * h) - (((w / gcd) + (h / gcd) - 1) * gcd)
        return W * H - (W + H - gcd(W, H));
    }

    private long gcd(long w, long h) {
        long big = Math.max(w, h);
        long small = Math.min(w, h);

        while (small > 0) {
            long tmp = big % small;

            big = small;
            small = tmp;
        }

        return big;
    }

}
