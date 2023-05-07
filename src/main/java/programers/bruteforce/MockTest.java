package programers.bruteforce;

public class MockTest {

    public static int[] solution(int[] answers) {
        int[][] math1 = {{0}, {1, 2, 3, 4, 5, 1, 2, 3, 4, 5}};       // 10
        int[][] math2 = {{0}, {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5}};     // 16
        int[][] math3 = {{0}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};     // 20

        int correct1 = 0;
        int correct2 = 0;
        int correct3 = 0;

        int max = 0;

        for (int i = 0; i < answers.length; i++) {
            if (math1[1][i % math1[1].length] == answers[i]) {
                correct1++;
            }
            if (math2[1][i % math2[1].length] == answers[i]) {
                correct2++;
            }
            if (math3[1][i % math3[1].length] == answers[i]) {
                correct3++;
            }

            max = Math.max(Math.max(correct1, correct2), correct3);

        }

        int count = 0;
        if (correct1 == max) {
            count++;
            math1[0][0] = 1;
        }
        if (correct2 == max) {
            count++;
            math2[0][0] = 1;
        }
        if (correct3 == max) {
            count++;
            math3[0][0] = 1;
        }

        int[] answer = new int[count];

        int k = 0;
        if (math1[0][0] == 1) {
            answer[k] = 1;
            k++;
        }
        if (math2[0][0] == 1) {
            answer[k] = 2;
            k++;
        }
        if (math3[0][0] == 1)
            answer[k] = 3;

        return answer;
    }

    public static void main(String[] args) {
        int[] result1 = solution(new int[]{1, 2, 3, 4, 5});
        for (int i : result1) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] result2 = solution(new int[]{1, 3, 2, 4, 2});
        for (int i : result2) {
            System.out.print(i + " ");
        }

    }

    /**
     * answers	    return
     * [1,2,3,4,5]	[1]
     * [1,3,2,4,2]	[1,2,3]
     */
}
