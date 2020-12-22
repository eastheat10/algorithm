package algo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		System.out.print("숫자를 입력하세요: ");
		int n = sc.nextInt();
		int size = 0;
		double highScore = 0;
		double per = 0;

		int[][] score = new int[n][];

//		System.out.println("숫자입력");
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
//			System.out.println("l: " + l);

			for(int j = 0; j < l; j++) {
				sum += score[i][j];
			}
//			System.out.println("sum: " + sum);

			avg = sum / (int)l;
//    		System.out.println("avg: " + avg);

			for(int j = 0; j < l; j++) {
				if(score[i][j] > avg)
					highScore++;
			}
//			System.out.println("hs: " + highScore);

			per = (highScore / l) * 100;
    		System.out.printf("%.3f%%\n", per);

			highScore = 0;
		}
	}
}
