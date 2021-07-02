package beakjoon.condition;

// 사분면 고르기

import java.util.Scanner;

public class A14681 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y;

		System.out.print("x: ");
		x = sc.nextInt();
		System.out.print("y: ");
		y = sc.nextInt();


		if(x == 0 && y ==0)
			System.out.println("원점입니다.");
		else if((x > 0) && (y > 0))		// 1 사분면
			System.out.println(1);
		else if ((x < 0) && (y > 0))	// 2 사분면
			System.out.println(2);
		else if((x < 0) && (y < 0))		// 3 사분면
			System.out.println(3);
		else							// 4 사분면
			System.out.println(4);
	}
}
