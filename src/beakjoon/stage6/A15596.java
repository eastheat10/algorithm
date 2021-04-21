package beakjoon.stage6;

//Java: long sum(int[] a); (클래스 이름: Test)
//a: 합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
//리턴값: a에 포함되어 있는 정수 n개의 합

import java.util.Scanner;

public class A15596 {

	public static long sum(int[] a) {
		long sum = 0;

		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하세요: ");
		int n = sc.nextInt();

		int[] a = new int[n];


		System.out.println(sum(a));

	}

}
