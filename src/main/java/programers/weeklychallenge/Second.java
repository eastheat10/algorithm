package programers.weeklychallenge;

import java.util.ArrayList;

/**
 * 프로그래머스 위클리 챌린지 2주차
 * https://programmers.co.kr/learn/courses/30/lessons/83201
 */
public class Second {

    public static String solution(int[][] scores) {
        StringBuilder sb = new StringBuilder();
        int len = scores.length;

        for (int j = 0; j < len; j++) {
            ArrayList<Integer> list = new ArrayList<>();
            int myScore = scores[j][j];
            for (int i = 0; i < len; i++)
                list.add(scores[i][j]);

            double avg = getAvg(list, myScore);
            sb.append(getGrade(avg));
        }

        return sb.toString();
    }

    static double getAvg(ArrayList<Integer> list, int score) {
        int len = list.size();
        double sum = list.stream().mapToDouble(a -> a).sum();

        list.sort((o1, o2) -> o1 - o2);

        if (list.get(0) == score) {
            if (list.get(1) != score) {
                return (sum - score) / (len - 1);
            }
        }

        if (list.get(len - 1) == score) {
            if (list.get(len - 2) != score) {
                return (sum - score) / (len - 1);
            }
        }

        return sum / len;
    }

    static String getGrade(double avg) {
        String score = "";

        if (avg >= 90)
            score = "A";
        else if (avg >= 80 && avg < 90)
            score = "B";
        else if (avg >= 70 && avg < 80)
            score = "C";
        else if (avg >= 50 && avg < 70)
            score = "D";
        else
            score = "F";

        return score;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{100, 90, 98, 88, 65},
                {50, 45, 99, 85, 77},
                {47, 88, 95, 80, 67},
                {61, 57, 100, 80, 65},
                {24, 90, 94, 75, 65}}));

        System.out.println(solution(new int[][]{{50, 90},
                {50, 87}}));

        System.out.println(solution(new int[][]{{70, 49, 90},
                {68, 50, 38},
                {73, 31, 100}}));
    }
}
