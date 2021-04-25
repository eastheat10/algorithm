package programers.bruteforce;

// 카펫
public class Carpet {

    public static int[] solution(int brown, int yellow) {

        int width = 0;
        int height = 0;

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int tmp = yellow / i;
                if (((tmp + i) * 2) + 4 == brown) {
                    if (tmp >= i) {
                        width = tmp;
                        height = i;
                    } else {
                        width = i;
                        height = tmp;
                    }
                    break;
                }
            }
        }

        return new int[]{width + 2, height + 2};

    }

    public static void main(String[] args) {
        int[] result1 = solution(10, 2);
        for (int i : result1) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        int[] result2 = solution(8, 1);
        for (int i : result2) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        int[] result3 = solution(24, 24);
        for (int i : result3) {
            System.out.print(i + " ");
        }
    }

    /**
     * brown	yellow	return
     * 10	    2   	[4, 3]
     * 8	    1	    [3, 3]
     * 24	    24	    [8, 6]
     */

}
