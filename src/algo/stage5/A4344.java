package algo.stage5;

//문제
//대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
//
//입력
//첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
//
//둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다.
//
//점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
//
//출력
//각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.

import java.util.Scanner;

public class A4344 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하세요: ");
		int n = sc.nextInt();
		int size = 0;
		double highScore = 0;
		double per = 0;

		int[][] score = new int[n][];

		System.out.println("숫자입력");
		for(int i = 0; i < n; i++) {
			size = sc.nextInt();
			score[i] = new int[size];
			for (int j = 0; j < size; j++) {
				score[i][j] = sc.nextInt();
			}
		}

		for(int i = 0; i < n; i++) {
			double l = score[i].length;
			int sum = 0;
			int avg = 0;
			System.out.println("l: " + l);

			for(int j = 0; j < l; j++) {
				sum += score[i][j];
			}
			System.out.println("sum: " + sum);

			avg = sum / (int)l;
			System.out.println("avg: " + avg);

			for(int j = 0; j < l; j++) {
				if(score[i][j] > avg)
					highScore++;
			}
			System.out.println("hs: " + highScore);

			per = (highScore / l) * 100;
			System.out.printf("%.3f\n\n", per);

			highScore = 0;
		}
	}

}
