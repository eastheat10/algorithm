package algo.stage3;

// 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제

import java.util.Scanner;

public class A2438 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		int n = sc.nextInt();
		int i;
		int count = 0;

		for(;n > 0; n--) {
			count++;
			for(i = 0; i < count; i++)
				System.out.print("*");
			System.out.println("");
		}
	}

}
