package beakjoon.stage1;

//세자리 수 곱셈

import java.util.Scanner;

public class A2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y;
//		System.out.print("첫번째 수: ");
		x = sc.nextInt();
//		System.out.print("두번째 수: ");
		y = sc.nextInt();

		int one, two, three, result;

		one = x * (y % 10);
		two = x * (y % 100 - (y % 10)) / 10;
		three = x * (y % 1000 - (y % 100)) / 100;

		result = x * y;

		System.out.printf("%d\n%d\n%d\n%d\n", one, two, three, result);
	}
}
